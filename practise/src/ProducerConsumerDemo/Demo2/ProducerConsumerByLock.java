package ProducerConsumerDemo.Demo2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Spaeurs
 * @date: 2021/8/10 10:26
 * @description: 生产者消费者模型：使用Lock和Condition实现
 */
public class ProducerConsumerByLock {

    private static final int CAPACITY = 5;

    private static final Lock lock = new ReentrantLock();
    //队列满的条件
    private static final Condition fullCondition = lock.newCondition();
    //队列空的条件
    private static final Condition emptyCondition = lock.newCondition();


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        Thread producer1 = new Producer("P-1", queue, CAPACITY);
        Thread producer2 = new Producer("P-2", queue, CAPACITY);
        Thread consumer1 = new Consumer("C1", queue, CAPACITY);
        Thread consumer2 = new Consumer("C2", queue, CAPACITY);
        Thread consumer3 = new Consumer("C3", queue, CAPACITY);

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }


    public static class Producer extends Thread {
        //线程名字
        String name;
        int maxSize;
        int i = 0;
        //生产者消息队列
        private Queue<Integer> queue;

        public Producer(String name, Queue<Integer> queue, int maxSize) {
            super(name);
            this.name = name;
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true) {
                //获得锁
                lock.lock();
                //消息队列已满，生产者线程进入wait状态
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("Queue is full, Producer[" + name + "] thread waiting for " +
                                "consumer to take something form queue");
                        //阻塞
                        fullCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("[" + name + "] Producing value: " + i);
                queue.offer(i++);

                //唤醒其他所有生产者、消费者
                fullCondition.signalAll();
                emptyCondition.signalAll();

                //释放锁
                lock.unlock();
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static class Consumer extends Thread {
        //线程名字
        String name;
        int maxSize;
        //消费者消息队列
        private Queue<Integer> queue;

        public Consumer(String name, Queue<Integer> queue, int maxSize) {
            super(name);
            this.queue = queue;
            this.name = name;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true) {

                //获得锁
                lock.lock();
                while (queue.isEmpty()) {
                    try {
                        System.out.println("Queue is empty, Consumer[" + name + "] thread is waiting for Producer");
                        //阻塞
                        emptyCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int x = queue.poll();
                System.out.println("[" + name + "] consuming value:" + x);

                //唤醒所有生产者消费者线程
                emptyCondition.signalAll();
                fullCondition.signalAll();

                //释放锁
                lock.unlock();
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
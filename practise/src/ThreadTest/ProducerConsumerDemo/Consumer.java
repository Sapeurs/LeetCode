package ThreadTest.ProducerConsumerDemo;

import java.util.List;

/**
 * @author: Sapeurs
 * @date: 2021/4/26 15:46
 * @description: 消费者模型
 */
public class Consumer implements Runnable {

    List<Integer> cache;

    public Consumer(List<Integer> cache) {
        this.cache = cache;
    }

    @Override
    public void run() {
        while (true) {
            consume();
        }
    }

    //消费消息
    private void consume() {
        synchronized (cache) {
            try {
                while (cache.isEmpty()) {
                    //当消息队列为空时，执行wait()方法，进入等待池
                    cache.wait();
                }

                System.out.println("Consumer consumed [" + cache.remove(0) + "]");

                //唤醒处于wait状态的线程，使其进入锁池，使用notify()可能会产生死锁,
                // 因为其唤醒的不一定是produce线程，有可能是consume线程
                //cache.notify();
                //改为使用notifyAll()
                cache.notifyAll();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
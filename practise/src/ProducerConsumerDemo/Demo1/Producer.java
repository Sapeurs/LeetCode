package ProducerConsumerDemo.Demo1;

import java.util.Queue;
import java.util.Random;

/**
 * @author: Spaeurs
 * @date: 2021/8/10 9:57
 * @description: 生产者模型
 */
public class Producer extends Thread{
    //生产者消息队列
    private Queue<Integer> queue;
    //线程名字
    String name;
    int maxSize;
    int i = 0;

    public Producer(String name, Queue<Integer> queue, int maxSize){
        super(name);
        this.name = name;
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                //消息队列已满，生产者线程进入wait状态
                while (queue.size() == maxSize){
                    try {
                        System.out.println("Queue is full, Producer["+name+"] thread waiting for " +
                                "consumer to take something form queue");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("[" + name + "] Producing value: " + i);
                queue.offer(i++);
                queue.notifyAll();

                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
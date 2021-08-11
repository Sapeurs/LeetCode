package ProducerConsumerDemo.Demo1;

import java.util.Queue;
import java.util.Random;

/**
 * @author: Spaeurs
 * @date: 2021/8/10 10:11
 * @description: 消费者模型
 */
public class Consumer extends Thread{
    //消费者消息队列
    private Queue<Integer> queue;
    //线程名字
    String name;
    int maxSize;

    public Consumer(String name, Queue<Integer> queue, int maxSize) {
        super(name);
        this.queue = queue;
        this.name = name;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                while (queue.isEmpty()){
                    try {
                        System.out.println("Queue is empty, Consumer[" + name + "] thread is waiting for Producer");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int x = queue.poll();
                System.out.println("["+name+"] consuming value:"+x);
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
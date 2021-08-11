package ProducerConsumerDemo.Demo3;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: Spaeurs
 * @date: 2021/8/10 11:01
 * @description:
 */
public class Consumer extends Thread{

    String name;
    int maxSize;
    private LinkedBlockingDeque<Integer> blockingDeque;
    int i = 0;

    public Consumer(String name, LinkedBlockingDeque<Integer> blockingDeque, int maxSize){
        super(name);
        this.name = name;
        this.blockingDeque = blockingDeque;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true){
            try {
                int x = blockingDeque.take();
                System.out.println("[" + name + "] consuming : " + x);

                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
package ProducerConsumerDemo.Demo3;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: Spaeurs
 * @date: 2021/8/10 11:01
 * @description:
 */
public class Producer extends Thread{

    private LinkedBlockingDeque<Integer> blockingDeque;
    String name;
    int maxSize;
    int i = 0;

    public Producer(String name, LinkedBlockingDeque<Integer> blockingDeque, int maxSize) {
        super(name);
        this.name = name;
        this.blockingDeque = blockingDeque;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true){
            try {
                blockingDeque.put(i);
                System.out.println("[" + name + "] Producing value : +" + i);
                i++;

                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
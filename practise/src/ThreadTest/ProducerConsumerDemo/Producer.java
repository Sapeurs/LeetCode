package ThreadTest.ProducerConsumerDemo;

import java.util.List;
import java.util.Random;

/**
 * @author: Sapeurs
 * @date: 2021/4/26 15:40
 * @description: 生产者模型
 */
public class Producer implements Runnable {

    //模拟生产消息缓冲队列
    List<Integer> cache;

    public Producer(List<Integer> cache) {
        this.cache = cache;
    }

    @Override
    public void run() {
        while (true) produce();
    }

    //生产消息
    private void produce() {
        synchronized (cache) {
            try {
                while (cache.size() == 1) {
                    //当队列中有一条消息时，进入wait状态
                    cache.wait();
                }
                //模拟一秒生产一条消息
                Thread.sleep(1000);
                cache.add(new Random().nextInt());

                //唤醒处于wait状态的线程，使用notify()可能会产生死锁
//                cache.notify();
                //改为使用notifyAll()
                cache.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
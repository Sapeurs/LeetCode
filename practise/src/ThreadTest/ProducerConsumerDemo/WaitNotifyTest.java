package ThreadTest.ProducerConsumerDemo;

import java.util.ArrayList;

/**
 * @author: Sapeurs
 * @date: 2021/4/26 15:54
 * @description: 测试wait notify  notifyAll
 */
public class WaitNotifyTest {

    public static void main(String[] args) {
        ArrayList<Integer> cache = new ArrayList<>();

        //新建一个消费者线程
        new Thread(new Consumer(cache)).start();
        //新建一个生产者线程
        new Thread(new Producer(cache)).start();

        //新建多个消费者线程，可能会产生死锁
        new Thread(new Consumer(cache)).start();
        new Thread(new Consumer(cache)).start();
        new Thread(new Consumer(cache)).start();
        //新建多个生产者线程
        new Thread(new Producer(cache)).start();
        new Thread(new Producer(cache)).start();
        new Thread(new Producer(cache)).start();
    }
}
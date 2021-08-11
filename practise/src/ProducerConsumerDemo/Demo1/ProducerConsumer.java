package ProducerConsumerDemo.Demo1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Spaeurs
 * @date: 2021/8/10 10:17
 * @description: 生产者消费者模型：使用Object.wait()/notify()方法实现
 */
public class ProducerConsumer {

    private static final int CAPACITY = 5;

    public static void main(String args[]){
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
}
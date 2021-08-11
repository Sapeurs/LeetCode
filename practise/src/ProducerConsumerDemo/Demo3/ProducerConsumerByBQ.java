package ProducerConsumerDemo.Demo3;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author: Spaeurs
 * @date: 2021/8/10 10:57
 * @description: 生产者消费者模型使用阻塞队列BlockQueue实现
 */
public class ProducerConsumerByBQ {
    private static final int CAPACITY = 5;

    public static void main(String[] args) {
        LinkedBlockingDeque<Integer> blockingQueue = new LinkedBlockingDeque<>(CAPACITY);
        Thread producer1 = new Producer("P-1", blockingQueue, CAPACITY);
        Thread producer2 = new Producer("P-2", blockingQueue, CAPACITY);
        Thread consumer1 = new Consumer("C1", blockingQueue, CAPACITY);
        Thread consumer2 = new Consumer("C2", blockingQueue, CAPACITY);
        Thread consumer3 = new Consumer("C3", blockingQueue, CAPACITY);

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}
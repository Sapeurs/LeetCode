package JUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Sapeurs
 * @date: 2021/7/6 14:40
 * @description:
 */
public class AQSDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        //3个线程模拟3个银行网点受理窗口办理业务的顾客

        // A 顾客就是第一个顾客，此时受理窗口没有任何人，A可以直接去办理
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("---------A thread come in");
                //暂停几秒钟线程
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        }, "A").start();

        //第二个顾客，第2个线程---> 由于受理业务的窗口只有一个（只能一个线程持有锁），此时B只能等待
        //进入候客区
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("---------B thread come in");
            } finally {
                lock.unlock();
            }
        }, "B").start();

        //第三个顾客，第3个线程---> 由于受理业务的窗口只有一个（只能一个线程持有锁），此时C只能等待
        //进入候客区
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("---------C thread come in");
            } finally {
                lock.unlock();
            }
        }, "C").start();
    }
}
package ThreadInterrupt;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Sapeurs
 * @date: 2021/6/9 10:12
 * @description: ReentrantLock() 中 lockInterruptibly() 方法的作用：
 * 如果当前线程未被中断则获得锁,如果当前线程被中断则出现异常
 * 如果线程已经被interrupt, 再使用lockInterruptibly的时候，此线程会被要求处理InterruptedException
 */
public class LockInterruptibly {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.serviceMethod();
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();

        Thread.sleep(50);
        Thread t2 = new Thread(runnable);
        t2.start();
        Thread.sleep(50);
        t2.interrupt();//中断t2线程
    }
}


class Service {
    private Lock lock = new ReentrantLock();

    public void serviceMethod() {
        try {
            //lock.lock();
            lock.lockInterruptibly(); //如果线程被中断了，不会获得锁，会产生异常
            System.out.println(Thread.currentThread().getName() + "--- begin lock");
            //执行一段耗时的操作
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                new StringBuilder();
            }
            System.out.println(Thread.currentThread().getName() + "--- end lock");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "**** 释放锁");
            lock.unlock();
        }
    }
}
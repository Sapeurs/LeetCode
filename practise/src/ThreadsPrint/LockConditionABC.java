package ThreadsPrint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Spaeurs
 * @date: 2021/9/12 20:36
 * @description:
 * 使用Lock+Condition交替打印ABC
 */
public class LockConditionABC {
    private int num;
    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    private static Condition condition3 = lock.newCondition();

    private void printABC(int targetNum, Condition currentThread, Condition nextThread){
        for (int i = 0; i < 10;) {
            lock.lock();
            try {
                while (num % 3 != targetNum){
                    //阻塞当前线程
                    currentThread.await();
                }
                num++;
                i++;
                System.out.println(Thread.currentThread().getName());
                //实现精准唤醒下一个线程，而不是唤醒所有线程
                nextThread.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        LockConditionABC lockConditionABC = new LockConditionABC();
        new Thread(()-> lockConditionABC.printABC(0,condition1,condition2),"A");
        new Thread(()-> lockConditionABC.printABC(1,condition2,condition3),"B").start();
        new Thread(()-> lockConditionABC.printABC(2,condition3,condition1),"C").start();
    }
}
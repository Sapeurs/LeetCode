package ThreadPoolPractise.threadPoolExcutor;

import java.util.Date;

/**
 * @author: Sapeurs
 * @date: 2021/4/15 14:38
 * @description: 一个简单的Runnable类
 */
public class MyRunnable implements Runnable {

    private String command;

    public MyRunnable(String s) {
        this.command = s;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    private void processCommand() {
        try {
            System.out.println(this.toString());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "第" + this.command + "个线程执行";
    }
}
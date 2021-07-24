package ThreadInterrupt;

/**
 * @author: Sapeurs
 * @date: 2021/6/8 17:12
 * @description: 测试线程的中断机制
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Task task = new Task();
//        Thread thread = new Thread(task);
//        thread.start();//启动任务线程
//        Thread.sleep(3000);//主线程休眠3秒
//        thread.interrupt();//3秒后中断任务线程


        MyThread t = new MyThread();
        t.start();
        Thread.sleep(1);
        t.interrupt();//中断t线程
        t.join();//等待t线程结束
        System.out.println("end");

    }

}


class Task implements Runnable {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {//检查线程中断状态
            System.out.println("I'm running...");
        }
        System.out.println("I'm stopped.");
    }
}


class MyThread extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
        }
    }
}
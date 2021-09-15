package ThreadsPrint;

/**
 * @author: Spaeurs
 * @date: 2021/9/12 20:12
 * @description:
 * 三个线程T1、T2、T3轮流打印ABC，打印n次，如ABCABCABCABC.......
 * 使用synchronized+wait/notify
 */
public class WaitNotifyABC {

    //控制打印线程
    private int num;
    private static final Object LOCK = new Object();

    private void printABC(int targetNum){
        for (int i = 0; i < 10; i++) {
            synchronized (LOCK){
                while (num % 3 != targetNum){
                    try {
                        //阻塞，释放锁
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num++;
                System.out.print(Thread.currentThread().getName());
                LOCK.notifyAll();
            }
        }

    }

    public static void main(String[] args) {
        WaitNotifyABC waitNotifyABC = new WaitNotifyABC();
        new Thread(()-> waitNotifyABC.printABC(0),"A").start();
        new Thread(()-> waitNotifyABC.printABC(1),"B").start();
        new Thread(()-> waitNotifyABC.printABC(2),"C").start();
    }

}
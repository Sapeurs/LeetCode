package Test;

/**
 * @author: Spaeurs
 * @date: 2021/9/14 19:50
 * @description:
 */
public class test23 {
    private static int a = 0;
    private synchronized static void add(){
        a++;
    }
    private synchronized void minus(){
        a--;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i <= 1000; i++) {
                add();
            }
        });

        Thread t2 = new Thread(() -> {
            test23 test = new test23();
            for (int i = 0; i <= 1000; i++) {
                test.minus();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("a" + a);
    }
}
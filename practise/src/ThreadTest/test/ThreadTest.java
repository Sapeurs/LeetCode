package ThreadTest.test;

/**
 * @author: Sapeurs
 * @date: 2021/5/6 15:51
 * @description: 启动三个线程交叉打印1-100
 */
public class ThreadTest {
    private volatile int i = 1;
    private volatile int f = 1;

    private Thread thread1, thread2, thread3;

    public void runTest() {
        thread1 = new Thread(new Thread1());
        thread2 = new Thread(new Thread2());
        thread3 = new Thread(new Thread3());
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.runTest();
    }

    class Thread1 implements Runnable {
        @Override
        public void run() {
            while (i <= 100) {
                if (f == 1) {
                    System.out.println("Thread1:" + i);
                    i++;
                    f = 2;
                }
            }
        }
    }

    class Thread2 implements Runnable {
        @Override
        public void run() {
            while (i <= 100) {
                if (f == 2) {
                    System.out.println("Thread2:" + i);
                    i++;
                    f = 3;
                }
            }
        }
    }

    class Thread3 implements Runnable {
        @Override
        public void run() {
            while (i <= 100) {
                if (f == 3) {
                    System.out.println("Thread3:" + i);
                    i++;
                    f = 1;
                }
            }
        }
    }
}


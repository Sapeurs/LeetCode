package Test.aiqiyi;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/8/22 16:21
 * @description:
 */
public class ZeroAndEvenOdd {
    private int n;
    private volatile int i = 1;
    private volatile int f = 1;
    private Thread thread1, thread2, thread3;

    public ZeroAndEvenOdd(int n){
        this.n = n;
    }

    public void printZero(){
        System.out.print(0);
    }

    public void printEven(int num){
        System.out.print(num);
    }

    public void printOdd(int num){
        System.out.print(num);
    }

    public void runTest() {
        thread1 = new Thread(new Thread1());
        thread2 = new Thread(new Thread2());
        thread3 = new Thread(new Thread3());
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ZeroAndEvenOdd zeroAndEvenOdd = new ZeroAndEvenOdd(n);
        zeroAndEvenOdd.runTest();
    }

    class Thread1 implements Runnable {
        @Override
        public void run() {
            while (i <= 2*n) {
                if (i%2 != 0) {
                    printZero();
                    i++;
                }
            }
        }
    }

    class Thread2 implements Runnable {
        @Override
        public void run() {
            while (i <= 2*n) {
                if (i%2 == 0 && f == 0) {
                    printEven(i/2);
                    i++;
                    f = 1;
                }
            }
        }
    }

    class Thread3 implements Runnable {
        @Override
        public void run() {
            while (i <= 2*n) {
                if (i%2 == 0 && f == 1) {
                    printOdd(i/2);
                    i++;
                    f = 0;
                }
            }
        }
    }
}
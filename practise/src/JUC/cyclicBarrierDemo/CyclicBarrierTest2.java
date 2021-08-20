package JUC.cyclicBarrierDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: Spaeurs
 * @date: 2021/8/19 15:39
 * @description: CyclicBarrier高级构造函数测试
 */
public class CyclicBarrierTest2 {

    //当线程到达屏障时，优先执行 A
    static CyclicBarrier c = new CyclicBarrier(2,new A());

    public static void main(String[] args) {
        new Thread(()->{
            try {
                c.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }).start();

        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }


    static class A implements Runnable{

        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
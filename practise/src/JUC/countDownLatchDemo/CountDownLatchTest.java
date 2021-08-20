package JUC.countDownLatchDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: Spaeurs
 * @date: 2021/8/19 15:21
 * @description: CountDownLatch测试
 */
public class CountDownLatchTest {

    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println(1);
            //每调用一次countDown()方法，计数器减1
            c.countDown();
            System.out.println(2);
            c.countDown();
        }).start();

        //await()会阻塞当前线程直到c的计数器变为0
        c.await();
        //当等待时间过长时，可以使用await(long time, TimeUnit unit)设置等待时间
//        c.await(3, TimeUnit.SECONDS);
        System.out.println(3);
    }

}
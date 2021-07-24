package ThreadPoolPractise.threadPoolExcutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: Sapeurs
 * @date: 2021/4/15 14:43
 * @description: 创建线程池类
 */
public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 20;
    private static final int QUEUE_CAPACITY = 30;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {

        //通过ThreadPoolExecutor构造函数自定义参数创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 1; i <= 100; i++) {
            //创建MyRunnable对象(MyRunnable实现了Runnable接口)
            Runnable worker = new MyRunnable("" + i);
            //执行Runnable
            executor.submit(worker);

//            Future<?> future = executor.submit(worker);
//            Object ans = future.get();
//            System.out.println(ans);
        }
        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
package DeadLock;

/**
 * @author: Spaeurs
 * @date: 2021/9/17 14:56
 * @description: 实现一个死锁
 */
public class DeadLockDemo {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (resource1){
                System.out.println(Thread.currentThread().getName() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "waiting get resource2");
                synchronized (resource2){
                    System.out.println(Thread.currentThread().getName() + "get resource1");
                }
            }
        },"线程 1").start();

        new Thread(()->{
            //synchronized (resource2){
            //解决办法是两个线程按顺序获取资源
            synchronized (resource1){
                System.out.println(Thread.currentThread().getName() + "get resource2");
                try {
                    //线程休眠，保证线程1先获得资源1
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "waiting get resource1");
                //synchronized (resource1){
                synchronized (resource2){
                    System.out.println(Thread.currentThread().getName() + "get resource2");
                }
            }
        },"线程 2").start();
    }
}
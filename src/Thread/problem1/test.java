package Thread.problem1;

/**
 * @author: Sapeurs
 * @date: 2021/4/25 21:03
 * @description: 1114. 按序打印
 */
public class test {
}


class Foo {

    //定义构造屏障，second线程等待first屏障，third线程等待second屏障，
    // first线程会释放first屏障，而second线程会释放second屏障
    private boolean firstFinished;
    private boolean secondFinished;
    //使用一个Object对象lock实现所有执行屏障的锁对象
    private Object lock = new Object();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (lock) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstFinished = true;
            lock.notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {

        synchronized (lock) {
            while (!firstFinished) {
                lock.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondFinished = true;
            lock.notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {

        synchronized (lock) {
            while (!secondFinished) {
                lock.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }

    }

}
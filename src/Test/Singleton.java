package Test;

/**
 * @author: Sapeurs
 * @date: 2021/5/15 10:49
 * @description:
 */
public class Singleton {

    private Singleton() {
    }

    private static volatile Singleton s = null;

    public static Singleton getInstance() {
        if (s == null) {
            synchronized (Singleton.class) {
                if (s == null) {
                    s = new Singleton();
                }
            }
        }
        return s;
    }

}


class Singleton1 {
    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return SingletonHolder.s;
    }

    private static class SingletonHolder {
        private static final Singleton1 s = new Singleton1();
    }
}
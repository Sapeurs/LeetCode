package Patterns.singletonDemo;

/**
 * @author: Sapeurs
 * @date: 2021/3/30 9:11
 * @description: 单例模式的实现
 */
public class Singleton {

}


/*
饿汉式的单例模式
 */
class Single {
    private static final Single s = new Single();

    private Single() {
    }

    public static Single getInstance() {
        return s;
    }
}

/*
懒汉式的单例模式
 */
class Single1 {
    private static Single1 s = null;

    private Single1() {
    }

    public static Single1 getInstance() {
        if (s == null)
            s = new Single1();
        return s;
    }
}

/*
完整模式：线程安全+Volatile

1.在堆内存上分配对象的存储空间
2.在堆内存上初始化对象
3.设置s指向刚分配的内存地址
Volatile防止第2步和第3步发生指令重排
 */
class Single2 {
    private static volatile Single2 s = null;

    private Single2() {
    }

    public static Single2 getInstance() {
        if (s == null) {//第一个判断s==null用来提升效率
            synchronized (Single2.class) {
                if (s == null)
                    s = new Single2();
            }
        }
        return s;
    }
}


/*
静态内部类实现单例模式
第一次加载Single3类时不会初始化s，只有在第一次调用getInstance()方法时，
虚拟机会加载SingletonHolder类，初始化s。
 */
class Single3 {
    //声明为private避免调用默认构造方法创建对象
    private Single3() {
    }

    //声明为private表明该静态内部类只能在该Single类中被访问
    private static class SingleHolder {
        private static final Single3 s = new Single3();
    }

    //内部类方式获取单例
    public static Single3 getInstance() {
        return SingleHolder.s;
    }


}

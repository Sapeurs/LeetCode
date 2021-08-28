package Patterns.observerDemo;

/**
 * 抽象观察者
 * @author: Spaeurs
 * @date: 2021/8/28 14:40
 * @description:
 */
public interface Observer {

    /**
     * 当被观察者调用notifyObservers()方法时，该方法会被回调
     * @param message
     */
    public void update(String message);

}

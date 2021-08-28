package Patterns.observerDemo;

/**
 * 抽象被观察者接口
 * 声明添加、删除、通知观察者方法
 * @author: Spaeurs
 * @date: 2021/8/28 14:38
 * @description:
 *
 */
public interface Observerable {

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}

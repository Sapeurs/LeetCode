package Patterns.observerDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义被观察者
 * @author: Spaeurs
 * @date: 2021/8/28 14:43
 * @description:
 */
public class Server implements Observerable{

    private List<Observer> list;
    private String message;

    public Server(){
        list = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        list.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o :list) {
            o.update(message);
        }
    }

    public void setInformation(String s){
        this.message = s;
        System.out.println("服务器消息更新：" + s);
        //消息更新，通知所有观察者
        notifyObservers();
    }
}
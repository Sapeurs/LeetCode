package Patterns.observerDemo;

/**
 * 定义观察者
 * @author: Spaeurs
 * @date: 2021/8/28 14:53
 * @description:
 */
public class User implements Observer{

    private String name;
    private String message;

    public User(String name){
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }


    public void read(){
        System.out.println(name + " 收到消息："+message);
    }
}
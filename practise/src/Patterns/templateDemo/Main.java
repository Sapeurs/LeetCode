package Patterns.templateDemo;

/**
 * @author: Spaeurs
 * @date: 2021/8/28 14:12
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.start();

        Cat cat = new Cat();
        cat.start();
    }
}


//抽象的父类
abstract class Animal{
    //定义抽象方法
    abstract void eat();
    abstract void run();

    //定义具体的模板方法
    public void start(){
        //定义一个框架，确定方法的执行步骤
        eat();
        run();
    }
}


//定义子类
class Dog extends Animal{

    @Override
    void eat() {
        System.out.println("小狗在吃东西");
    }

    @Override
    void run() {
        System.out.println("小狗在跑步");
    }
}

class Cat extends Animal{

    @Override
    void eat() {
        washHand();
        System.out.println("小猫在吃东西");
    }

    @Override
    void run() {
        System.out.println("小猫在跑步");
    }

    //其余业务逻辑
    private void washHand(){
        System.out.println("小猫在洗手");
    }
}
package Test;

/**
 * @author: Sapeurs
 * @date: 2021/4/29 19:09
 * @description:
 */
public class test4 {
    private int a = 10;
    int b = 20;
    static int c = 1;
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal b = new Dog();
        a.move();
        b.move();
        //b.bark();
        int i = 1;
        float j = 2;
        System.out.println(i/j);
        test4 t = new test4();
    }

}


class Animal{

    private int i = 0;

    public void move(){
        System.out.println("the animal is moving");
    }

    public synchronized void bark(){
        System.out.println("the animal");
    }

    class cat{
        //i = 0;
        void test(){
            System.out.println(i);
        }
    }
}


class Dog extends Animal{
    @Override
    public void move() {
        System.out.println("the dog is moving");
    }

    public void bark(){
        System.out.println("the dog can bark");
    }
}
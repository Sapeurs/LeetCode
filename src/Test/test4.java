package Test;

/**
 * @author: Sapeurs
 * @date: 2021/4/29 19:09
 * @description:
 */
public class test4 {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal b = new Dog();
        a.move();
        //b.bark();
    }
}


class Animal{
    public void move(){
        System.out.println("the animal is moving");
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
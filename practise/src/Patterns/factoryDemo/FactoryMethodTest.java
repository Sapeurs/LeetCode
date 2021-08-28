package Patterns.factoryDemo;

/**
 * @author: Spaeurs
 * @date: 2021/8/28 13:33
 * @description:
 * 工厂方法模式定义了一个用于创建对象的接口，让子类决定实例化哪一个类。
 * 工厂方法模式使一个类的实例化延迟到其子类。
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        //创建具体的创建类对象
        ConcreteCreator creator = new ConcreteCreator();
        //通过传入指定的产品类对象，来创建对应的产品
        Product product = creator.createProduct(ConcreteProduct1.class);
        //创建对象之后，可以进行业务逻辑处理
        product.method1();
        product.method2();
    }
}


//定义抽象产品类
abstract class Product{
    //产品类的公共方法
    public void method1(){
        System.out.println("公共的业务逻辑");
    }

    //抽象方法
    public abstract void method2();
}


//定义具体产品类
class ConcreteProduct1 extends Product{

    @Override
    public void method2() {
        System.out.println("具体产品类1的业务逻辑处理");
    }
}

class ConcreteProduct2 extends Product{

    @Override
    public void method2() {
        System.out.println("具体产品类2的业务逻辑处理");
    }
}

//定义抽象创建工厂类
abstract class Creator{
    //创建对象的抽象方法
    public abstract <T extends Product> T createProduct(Class<T> c);
}

//定义具体的创建工厂类，真正来创建所需的对象
class ConcreteCreator extends Creator{

    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product product = null;
        try {
            //通过反射来创建对象
            product = (Product) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
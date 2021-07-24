package Jdk8.java1;

import org.testng.annotations.Test;

import java.util.Comparator;

/**
 * @author: Sapeurs
 * @date: 2021/6/29 14:55
 * @description: JDK8的lambda表达式使用举例
 * <p>
 * Lambda的本质就是作为一个函数式接口的实例
 */
public class LambdaTest {

    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("测试");
            }
        };

        r1.run();

        System.out.println("**********************");

        Runnable r2 = () -> System.out.println("测试2");

        r2.run();
    }


    @Test
    public void test2() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);

        System.out.println("********************");

        //当Lambda体只有一条语句时，return与大括号都可以省略
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);

        int compare2 = com2.compare(12, 32);
        System.out.println(compare2);
    }
}
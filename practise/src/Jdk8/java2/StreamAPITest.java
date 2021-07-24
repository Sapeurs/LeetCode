package Jdk8.java2;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: Sapeurs
 * @date: 2021/6/29 16:33
 * @description: 1.Stream关注的是对数据的运算，
 * 集合关注的是数据的存储
 * <p>
 * 2.Stream执行流程
 * ① Stream的实例化
 * ② 一系列的中间操作（过滤，映射、...）
 * ③终止操作
 * <p>
 * <p>
 * <p>
 * <p>
 * 测试Stream的实例化
 */
public class StreamAPITest {

    //创建Stream方式一：通过集合
    @Test
    public void test1() {

        ArrayList<Integer> list = new ArrayList<>();

        //default Stream<E> stream() : 返回一个顺序流
        Stream<Integer> stream = list.stream();

        //default Stream<E> parallelStream() : 返回一个并行流
        Stream<Integer> parallelStream = list.parallelStream();
    }

    //创建Stream方式二：通过数组
    @Test
    public void test2() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        //调用Arrays类的public static <T> Stream<T> stream(T[] array):返回一个流
        IntStream stream = Arrays.stream(arr);

    }

    //创建Stream方式三：通过Stream的of()
    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

    }

    //创建Stream方式四：创建无限流
    @Test
    public void test4() {
        //迭代
        //public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

//      生成
//      public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    //Stream的映射
    @Test
    public void test5() {
        //map(Function f)-接收一个函数作为参数，将元素转换为其他形式或提取信息
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        System.out.println("****************************");

        //使用map有两个流
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest::fromStringToStream);
        streamStream.forEach(s -> s.forEach(System.out::println));

        System.out.println("****************************");
        //flatMap(Function f)-接收一个函数作为参数，将流中的每个值都换成另一个流
        list.stream().flatMap(StreamAPITest::fromStringToStream).forEach(System.out::println);
    }

    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c :
                str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    //排序
    @Test
    public void test6() {
        //sorted()--自然排序
        List<Integer> list = Arrays.asList(12, 34, 54, 62, 677, 121, 75);
        list.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com)--定制排序
    }
}
package Test.thoughtWorks;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Spaeurs
 * @date: 2021/9/4 15:41
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(7);
        list.add(12);
        list.add(32);
        list.add(43);
        List<Integer> list1 = evenTheOdds(list);
        System.out.println(list1.toString());
    }

    public static List<Integer> evenTheOdds(List<Integer> array) {
        array.removeIf(i -> i % 2 != 0);
        return array;
    }
}
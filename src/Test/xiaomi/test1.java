package Test.xiaomi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: Sapeurs
 * @date: 2021/9/1 20:06
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = IntStream.range(1, n+1).boxed().collect(Collectors.toList());
        int num = 1;
//        for (int i = 0; 1!=list.size(); i++) {
//            if (i==list.size())
//                i=0;
//            if (num%3 == 0){
//                list.remove(i);
//                i--;
//            }
//            num++;
//        }
        int i = 0;
        while (list.size() != 1){
            if (i==list.size())
                i=0;
            if (num%3 == 0){
                list.remove(i);
                i--;
            }
            num++;
            i++;
        }
        System.out.println(list.get(0));
    }
}

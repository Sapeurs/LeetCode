package Test;

import java.io.*;
import java.util.*;

/**
 * @author: Sapeurs
 * @date: 2021/4/28 20:31
 * @description:
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int w = sc.nextInt();
//        int k = sc.nextInt();
//        sc.nextLine();
//        int[] height = new int[n];
//        for (int i = 0; i < n; i++) {
//            height[i] = sc.nextInt();
//        }
//
//        int[] count = new int[n];
//        count[0] = 0;
//        for (int i = 1; i < n; i++) {
//            count[i] = height[i - 1] + count[i - 1] * k > w ? count[i - 1] + 1 : count[i - 1];
//        }
//
//        int cost = 0;
//        for (int i = 0; i < n; i++) {
//            if (height[i] + count[i] * k > w) {
//                cost += (height[i] + (count[i] * k)) - w;
//            }
//        }
//        System.out.println(cost);
//
//        String s = "abcdefg";
//        String str1 = "hello";
//        String str2 = new String("hello").intern();
//        System.err.println(str1 == str2);

//        Deque<Integer> deque = new LinkedList<>();
//        deque.addLast(1);
//        deque.addLast(2);
//        deque.addLast(3);
//        System.out.println(deque.removeFirst());

        Single single = Single.getInstance();
        System.out.println(single.value1);
        System.out.println(single.value2);

    }





}

class Single{
    private static Single single = new Single();

    public static int value1;
    public static int value2 = 0;

    private Single(){
        value1++;
        value2++;
    }

    public static Single getInstance() {
        return single;
    }
}
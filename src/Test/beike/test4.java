package Test.beike;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/3 19:05
 * @description:
 */
public class test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] cols = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cols[i] = sc.nextInt();
            for (int j = 0; j < cols[i] * 2; j++) {
                list.add(sc.nextInt());
            }
        }

        System.out.println(list.toString());
    }
}
package Test.leihuo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/18 15:00
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int radius = sc.nextInt();
        int count = sc.nextInt();
        int[][] monsters = new int[count][2];
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            monsters[i][0] = sc.nextInt();
            monsters[i][1] = sc.nextInt();
        }



        for (int i = 0; i < count; i++) {
            System.out.println(Arrays.toString(monsters[i]));
        }
    }
}
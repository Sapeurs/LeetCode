package Test.leihuo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/18 14:25
 * @description:
 */
public class test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] player = new int[M][2];
        sc.nextLine();
        for (int i = 0; i < M; i++) {
            player[i][0] = sc.nextInt();
            player[i][1] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            System.out.println(Arrays.toString(player[i]));
        }

    }
}
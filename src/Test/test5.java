package Test;

import java.util.Scanner;

/**
 * @author: Sapeurs
 * @date: 2021/4/29 19:26
 * @description:
 */
public class test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        int col = 0, row = 0, count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

            }
        }
        System.out.println(count);
    }
}
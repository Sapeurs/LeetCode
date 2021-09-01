package Test.ali;

import java.util.Scanner;

/**
 * @author: Sapeurs
 * @date: 2021/9/1 9:42
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] nums = new int[M][2];
        for (int i = 0; i < M; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println(s);
    }
}

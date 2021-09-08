package Test.baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/7 19:30
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] ints = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ints[i][j] = sc.nextInt();
            }
        }

        int[][] ans = new int[N*K][N*K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int l = 0; l < K; l++) {
                    for (int m = 0; m < K; m++) {
                        ans[i*K + l][j* K +m] = ints[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < N * K; i++) {
            for (int j = 0; j < N * K; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }
}
package Test.tencent;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/5 20:54
 * @description:
 */
public class test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n-1; i++) {
            dp[i][i+1] = true;
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                if ((dp[i][j-1] && (nums[j-1]>=nums[j])) || (dp[i+1][j] &&(nums[i+1]>=nums[i]))){
                    dp[i][j] = j != i + 2 || nums[i] >= nums[j];
                }

            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j])
                    res++;
            }
        }
        System.out.println(res);
    }
}
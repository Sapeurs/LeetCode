package string.xiecheng;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/9 19:30
 * @description:
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        int[][] rules = new int[m][2];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            rules[i][0] = a;
            rules[i][1] = b;
            sc.nextLine();
        }

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i] == 0 && i != 0){
                    dp[i][j] = dp[i-1][j];
                }else {
                    if (i + 1 >= rules[j][0]){
                        int max = 0;
                        for (int k = 0; k < m; k++) {
                            max = Math.max(max,dp[i+1-j][k]);
                        }
                        dp[i][j] = max + rules[j][1];
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            ans = Math.max(ans,dp[n-1][i]);
        }
        System.out.println(ans);

    }
}
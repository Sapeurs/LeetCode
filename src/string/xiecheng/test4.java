package string.xiecheng;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/9 20:44
 * @description:
 */
public class test4 {
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
        int[] dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j>=rules[i][0])
                    dp[j] = Math.max(dp[j-rules[i][0]] + rules[i][1], dp[j]);
            }
        }

        int tmp = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0){
                ans += dp[i-tmp];
                tmp = i+1;
            }
        }
        ans += dp[n-tmp];
        System.out.println(ans);
    }
}
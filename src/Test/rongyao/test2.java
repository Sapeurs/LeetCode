package Test.rongyao;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/18 18:31
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String[] strs1 = str1.split(",");
        String[] strs2 = str2.split(",");
        helper(strs1);
        helper(strs2);
    }

    static void helper(String[] strs){
        int len = strs.length;
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            String tmp = strs[i].substring(1);
            if (tmp.length() == 2)
                ints[i] = 10;
            else if (tmp.charAt(0) == 'J')
                ints[i] = 11;
            else if (tmp.charAt(0) == 'Q')
                ints[i] = 12;
            else if (tmp.charAt(0) == 'K')
                ints[i] = 13;
            else if (tmp.charAt(0) == 'A')
                ints[i] = 1;
            else
                ints[i] = tmp.charAt(0) - '0';
        }

        int[] dp = new int[len];
        int Max = Integer.MIN_VALUE;
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = i-1; j >= 0; j--) {
                if (ints[i] > ints[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            if (dp[i] > Max) Max = dp[i];
            //Max = Math.max(Max,dp[i]);
        }
        System.out.println((len - Max) % 2 == 1 ? "Y" : "N");
    }
}
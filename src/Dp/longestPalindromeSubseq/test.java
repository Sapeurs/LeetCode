package Dp.longestPalindromeSubseq;

/**
 * @author: Spaeurs
 * @date: 2021/7/29 9:17
 * @description: 516. 最长回文子序列
 *
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 *
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除
 * 任何字符形成的一个序列。
 *
 *
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindromeSubseq("babadc"));
    }
}


class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        char[] chars = s.toCharArray();
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < len; j++) {
                if (chars[i] == chars[j])
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }

        return dp[0][len-1];
    }
}
package Dp.problem1;

/**
 * @author: Sapeurs
 * @date: 2021/4/22 9:29
 * @description: 1143.最长公共子序列
 * 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。
 * 如果不存在公共子序列 ，返回 0 。
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的
 * 相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 */
public class test {
}


class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i < m+1; i++) {
            char c1 = text1.charAt(i-1);
            for (int j = 1; j < n+1; j++) {
                char c2 = text2.charAt(j-1);
                if (c1 == c2)
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }

    //空间优化
    public int longestCommonSubsequence1(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[] pre = new int[n+1];
        int[] cur = new int[n+1];
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1))
                    cur[j] = pre[j-1] + 1;
                else
                    cur[j] = Math.max(cur[j-1], pre[j]);
            }
            if (n + 1 >= 0) System.arraycopy(cur, 0, pre, 0, n + 1);
        }
        return cur[n];
    }
}
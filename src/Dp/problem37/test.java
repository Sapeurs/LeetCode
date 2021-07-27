package Dp.problem37;

/**
 * @author: Spaeurs
 * @date: 2021/7/29 9:17
 * @description: 221. 最大正方形
 * <p>
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class test {
}


class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == '0') dp[i][j] = 0;
//                else if (i==0||j==0) dp[i][j] = 1;
//                else dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                if (matrix[i][j] == '1'){
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max * max;
    }
}
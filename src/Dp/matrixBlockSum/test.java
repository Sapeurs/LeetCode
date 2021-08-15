package Dp.matrixBlockSum;

import java.util.Arrays;

/**
 * @author: Spaeurs
 * @date: 2021/7/27 20:36
 * @description: 1314. 矩阵区域和
 * <p>
 * 给你一个m x n的矩阵mat和一个整数 k ，请你返回一个矩阵answer，
 * 其中每个answer[i][j]是所有满足下述条件的元素mat[r][c] 的和：
 * <p>
 * i - k <= r <= i + k,
 * j - k <= c <= j + k 且
 * (r, c)在矩阵内。
 */
public class test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.matrixBlockSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1)));
    }
}


class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + mat[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //左上角坐标
                int m1 = Math.max(i - k, 0);
                int n1 = Math.max(j - k, 0);
                //右下角坐标
                int m2 = Math.min(i + k, m - 1);
                int n2 = Math.min(j + k, n - 1);
                res[i][j] = dp[m2 + 1][n2 + 1] - dp[m1][n2 + 1] - dp[m2 + 1][n1] + dp[m1][n1];
            }
        }
        return res;
    }
}
package Dp.problem33;

import java.util.Arrays;

/**
 * @author: Spaeurs
 * @date: 2021/7/27 19:12
 * @description: 931. 下降路径最小和
 * <p>
 * 给你一个 n x n 的 方形 整数数组 matrix ，
 * 请你找出并返回通过 matrix 的下降路径 的 最小和 。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minFallingPathSum(new int[][]{{-19, 57},
                {-40, -5}}));
    }
}

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = matrix[0].clone();
        int[] tmp = matrix[0].clone();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0)
                    dp[j] = Math.min(tmp[j], tmp[j + 1]) + matrix[i][j];
                else if (j == n - 1)
                    dp[j] = Math.min(tmp[j - 1], tmp[j]) + matrix[i][j];
                else
                    dp[j] = Math.min(Math.min(tmp[j - 1], tmp[j]), tmp[j + 1]) + matrix[i][j];
            }
            tmp = dp.clone();
        }
        Arrays.sort(dp);
        return dp[0];
    }

    //直接修改原数组
    public int minFallingPathSum1(int[][] matrix) {
        int n = matrix.length;
        for (int r = n - 2; r >= 0; r--) {
            for (int c = 0; c < n; c++) {
                //best = min(matrix[r+1][c-1], matrix[r+1][c], matrix[r+1][c+1])
                int best = matrix[r + 1][c];
                if (c > 0)
                    best = Math.min(best, matrix[r + 1][c - 1]);
                if (c + 1 < n)
                    best = Math.min(best, matrix[r + 1][c + 1]);
                matrix[r][c] += best;
            }
        }
        Arrays.sort(matrix[0]);
        return matrix[0][0];
    }
}
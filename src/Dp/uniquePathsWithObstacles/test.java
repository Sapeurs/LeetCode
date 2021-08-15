package Dp.uniquePathsWithObstacles;

/**
 * @author: Spaeurs
 * @date: 2021/7/28 20:39
 * @description: 63. 不同路径 II
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 */
public class test {
}


class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 0 ? 1: 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //如果此位置有障碍物，则不可达
                if (obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j-1] == 0){
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[n-1];
    }
}
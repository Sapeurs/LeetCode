package Dp.problem4;

/**
 * @author: Sapeurs
 * @date: 2021/3/24 21:45
 * @description: 剑指 Offer 47. 礼物的最大价值
 * 最大路径和
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = new int[][]{{1, 2, 5},
                {3, 2, 1}};
        System.out.println(solution.maxValue(ints));
    }
}


//动态规划
class Solution {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        //dp[i][j]表示从grid[0][0]到grid[i - 1][j - 1]时的最大价值
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][column];
    }
}


class Solution2 {
    public int maxValue(int[][] grid) {
        int sum = grid[0][0];
        int i = 0, j = 0;
        while (true) {
            if (i == grid.length - 1 && j == grid[0].length - 1) {
//                value = grid[i][j];
//                sum += value;
                break;
            }
            if (i == grid.length - 1) {
                j++;
            } else if (j == grid[0].length - 1) {
                i++;
            } else {
                if (grid[i + 1][j] > grid[i][j + 1]) {
                    i++;
                } else {
                    j++;
                }
            }
            sum += grid[i][j];
        }
        return sum;
    }
}
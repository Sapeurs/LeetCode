package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Spaeurs
 * @date: 2021/8/21 15:27
 * @description:
 */
public class test16 {
    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        System.out.println(solution13.minSailCost(
                new int[][]{{1, 1, 1, 1, 0},
                        {0, 1, 0, 1, 0},
                        {1, 1, 2, 1, 1},
                        {0, 2, 0, 0, 1}}));
    }
}
/*
 write code here
        int m = input.length;
        int n = input[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j==1&&i==1) continue;
                if (input[i - 1][j - 1] == -1)
                    dp[i][j] = -1;
                else if (input[i - 1][j - 1] == 0) {
                    if (dp[i - 1][j] != -1 && dp[i][j - 1] != -1)
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 2;
                    else if (dp[i - 1][j] == -1)
                        dp[i][j] = dp[i][j - 1] + 2;
                    else dp[i][j] = dp[i - 1][j] + 2;
                } else {
                    if (dp[i - 1][j] != -1 && dp[i][j - 1] != -1)
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    else if (dp[i - 1][j] == -1)
                        dp[i][j] = dp[i][j - 1] + 1;
                    else dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }
        return dp[m][n];
*/

class Solution13 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 计算最小航行费用
     *
     * @param input int整型二维数组 二维网格
     * @return int整型
     */

/*
    int count = 0;
    List<Integer> ans = new ArrayList<>();

    public int minSailCost(int[][] input) {

        int m = input.length;
        int n = input[0].length;
        dfs(input, new boolean[m][n], 0, 0, m, n);

        return Collections.min(ans);
    }

    void dfs(int[][] input, boolean[][] isVisited, int row, int col, int m, int n) {
        if (row < 0 || row >= m || col < 0 || col >= n || isVisited[row][col] || input[row][col] == 2)
            return;
        if (row == m - 1 && col == n - 1) {
            ans.add(count - input[0][0]);
            return;
        }
        count += input[row][col];
        isVisited[row][col] = true;
        dfs(input, isVisited, row + 1, col, m, n);
        dfs(input, isVisited, row - 1, col, m, n);
        dfs(input, isVisited, row, col + 1, m, n);
        dfs(input, isVisited, row, col - 1, m, n);
        isVisited[row][col] = false;
        count -= input[row][col];
    }
*/

    public int minSailCost(int[][] input) {
        /*
 write code here
 */
        int m = input.length;
        int n = input[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j==1&&i==1) continue;
                if (input[i - 1][j - 1] == -1)
                    dp[i][j] = -1;
                else if (input[i - 1][j - 1] == 0) {
                    if (dp[i - 1][j] != -1 && dp[i][j - 1] != -1)
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 2;
                    else if (dp[i - 1][j] == -1)
                        dp[i][j] = dp[i][j - 1] + 2;
                    else dp[i][j] = dp[i - 1][j] + 2;
                } else {
                    if (dp[i - 1][j] != -1 && dp[i][j - 1] != -1)
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    else if (dp[i - 1][j] == -1)
                        dp[i][j] = dp[i][j - 1] + 1;
                    else dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }
        return dp[m][n];

    }

}
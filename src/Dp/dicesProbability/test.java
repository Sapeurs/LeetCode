package Dp.dicesProbability;

import java.util.Arrays;

/**
 * @author: Spaeurs
 * @date: 2021/11/20 21:04
 * @description: 剑指 Offer 60. n个骰子的点数
 * <p>
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。
 * 输入n，打印出s的所有可能的值出现的概率。
 * <p>
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素
 * 代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 */
public class test {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().dicesProbability(3)));
    }
}


class Solution {
    public double[] dicesProbability(int n) {
        double[] res = new double[5 * n + 1];
        double[][] dp = new double[n + 1][n * 6 + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1.0 / 6;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i * 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k > 0) {
                        dp[i][j] += dp[i - 1][j - k] / 6;
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i <= 5 * n; i++) {
            res[i] = dp[n][n + i];
        }
        return res;
    }
}
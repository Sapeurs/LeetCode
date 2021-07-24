package Dp.problem25;

/**
 * @author: Sapeurs
 * @date: 2021/7/22 21:15
 * @description: 309. 最佳买卖股票时机含冷冻期
 * <p>
 * 给定一个整数数组，其中第i个元素代表了第i天的股票价格 。
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易
 * （多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 */
public class test {
}


class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;

        //f[i][0]：手上持有股票的最大收益
        //f[i][1]：手上不持有股票且处在冷静期的累计最大收益
        //f[i][2]：手上不持有股票且不处在冷静期的累计最大收益
        int[][] f = new int[len][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            //第i天手上持有股票的情况可以由第i-1天手上持有股票
            // 或者第i-1天不持有股票且不在冷静期再加上买入第i天股票的状态转移而来
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            //第i天结束之后处于冷静期的原因是在第i天卖出了股票
            //说明在第i-1天时必须持有一只股票，只能由f[i][0]转移而来
            f[i][1] = f[i - 1][0] + prices[i];
            //第i天结束之后不持有股票并且不在冷静期说明当天没有进行任何操作
            //也就是第i-1天不持有任何股票，可能由f[i][1]或者f[i][2]转移而来
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[len - 1][1], f[len - 1][2]);
    }


    //空间优化，f[i]只与f[i-1]有关，与之前的状态都无关，所以可以通过变量存储三个状态
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;

        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int i = 1; i < len; i++) {
            int newf0 = Math.max(f0, f2 - prices[i]);
            int newf1 = f0 + prices[i];
            int newf2 = Math.max(f1, f2);
            f0 = newf0;
            f1 = newf1;
            f2 = newf2;
        }
        return Math.max(f1, f2);
    }
}
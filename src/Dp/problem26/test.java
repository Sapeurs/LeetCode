package Dp.problem26;

/**
 * @author: Spaeurs
 * @date: 2021/7/24 19:12
 * @description: 714. 买卖股票的最佳时机含手续费
 * <p>
 * 给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；
 * 整数fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。
 * 如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
 */

public class test {
}


class Solution {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < len; i++) {
            int newdp0 = Math.max(dp0, dp1 + prices[i] - fee);
            int newdp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newdp0;
            dp1 = newdp1;
        }
        return dp0;
    }
}
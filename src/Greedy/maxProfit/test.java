package Greedy.maxProfit;

/**
 * @author: Sapeurs
 * @date: 2021/5/5 16:00
 * @description: 122.买卖股票的最佳时机II
 * <p>
 * 给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(solution.maxProfit(prices));
    }
}


class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            //直接将价格上涨时的累加
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
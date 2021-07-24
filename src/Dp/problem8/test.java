package Dp.problem8;

/**
 * @author: Sapeurs
 * @date: 2021/4/27 21:08
 * @description: 剑指offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class test {
}


class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
//            if (price < minPrice) {
//                minPrice = price;
//            } else if (price - minPrice > maxProfit) {
//                maxProfit = price - minPrice;
//            }
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }


}
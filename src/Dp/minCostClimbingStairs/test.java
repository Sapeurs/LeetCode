package Dp.minCostClimbingStairs;

/**
 * @author: Sapeurs
 * @date: 2021/7/14 20:02
 * @description: 746. 使用最小花费爬楼梯
 * <p>
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值cost[i]（下标从 0 开始）。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，
 * 你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * <p>
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20}));
    }
}


class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= len; i++) {
            //可以从下标i-1使用cost[i-1]的花费达到下标i,或者从下标i-2使用cost[i-2]的花费达到下标i
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[len];
    }

    public int minCostClimbingStairs1(int[] cost) {
        int len = cost.length;
        int pre = 0, cur = 0, res = 0;
        for (int i = 2; i <= len; i++) {
            res = Math.min(pre + cost[i - 2], cur + cost[i - 1]);
            pre = cur;
            cur = res;
        }
        return res;
    }
}
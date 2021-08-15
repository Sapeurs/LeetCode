package Dp.numberOfArithmeticSlices;

/**
 * @author: Spaeurs
 * @date: 2021/7/25 20:19
 * @description: 413. 等差数列划分
 *
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 *
 * 子数组 是数组中的一个连续序列。
 *
 *
 */
public class test {
}


class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        int res = 0;
        //dp表示结尾元素时nums[i]的等差数列的个数
        int[] dp = new int[len];
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                dp[i] = dp[i-1] + 1;
                res += dp[i];
            }
        }
        return res;
    }

    public int numberOfArithmeticSlices1(int[] nums) {
        int len = nums.length;
        int res = 0;
        //dp表示结尾元素时nums[i]的等差数列的个数
        int dp = 0;
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                dp = dp + 1;
                res += dp;
            }else
                dp = 0;
        }
        return res;
    }
}
package Dp.problem21;

/**
 * @author: Sapeurs
 * @date: 2021/7/21 19:36
 * @description: 918. 环形子数组的最大和
 * <p>
 * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
 * <p>
 * 有两种情况：
 * 1.不包括环：只需要求出最大子序和
 * 2.包括环：则肯定包含第一个元素和最后一个元素并且这两个元素之间必定包含负数
 * 因此只需要把这些负数的最小和求出来，用整个数组的和sum减去这个负数
 * 最小和就是最大子序和
 */
public class test {
}


class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int dp = nums[0];
        int max = dp, sum = dp;

        //求最大子序列和
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            dp = nums[i] + Math.max(dp, 0);
            max = Math.max(dp, max);
        }

        //包括环的情况
        int min = 0;
        dp = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp = nums[i] + Math.min(0, dp);
            min = Math.min(dp, min);
        }
        return Math.max(sum - min, max);
    }
}
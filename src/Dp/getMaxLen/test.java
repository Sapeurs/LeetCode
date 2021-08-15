package Dp.getMaxLen;

/**
 * @author: Sapeurs
 * @date: 2021/7/21 21:46
 * @description: 1567. 乘积为正数的最长子数组长度
 * <p>
 * 给你一个整数数组 nums，请你求出乘积为正数的最长子数组的长度。
 * <p>
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 * <p>
 * 请你返回乘积为正数的最长子数组长度。
 */
public class test {
}

class Solution {
    public int getMaxLen(int[] nums) {
        int res = 0;
        int z = 0, f = 0;
        for (int n : nums) {
            if (n == 0) {
                z = 0;  // 正数长度
                f = 0;  // 负数长度
            } else if (n > 0) {
                z++;
                if (f > 0) f++;
                res = Math.max(res, z);
            } else {
                int temp = z;
                z = f;
                f = temp;
                f++;
                if (z > 0) z++;
                res = Math.max(res, z);
            }
        }
        return res;
    }

    public int getMaxLen1(int[] nums) {
        int length = nums.length;
        int positive = nums[0] > 0 ? 1 : 0;
        int negative = nums[0] < 0 ? 1 : 0;
        int maxLength = positive;
        for (int i = 1; i < length; i++) {
            if (nums[i] > 0) {
                positive++;
                negative = negative > 0 ? negative + 1 : 0;
            } else if (nums[i] < 0) {
                int newPositive = negative > 0 ? negative + 1 : 0;
                int newNegative = positive + 1;
                positive = newPositive;
                negative = newNegative;
            } else {
                positive = 0;
                negative = 0;
            }
            maxLength = Math.max(maxLength, positive);
        }
        return maxLength;
    }
}
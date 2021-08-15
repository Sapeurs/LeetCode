package Dp.maxProduct;

/**
 * @author: Sapeurs
 * @date: 2021/7/21 20:54
 * @description: 152. 乘积最大子数组
 * <p>
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连
 * 续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class test {
}


class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
}
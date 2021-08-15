package Dp.maxSubArray;

/**
 * @author: Sapeurs
 * @date: 2021/4/25 21:51
 * @description: 53.最大子序和
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 */
public class test {
}


class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int[] dp = new int[len];
        int temp = dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (temp < dp[i]) {
                temp = dp[i];
            }
        }

        return temp;
    }


    public int maxSubArray1(int[] nums) {
        //使用ans来保存最大子序和
        int ans = nums[0];
        //sum用来遍历每个数字
        int sum = 0;
        for (int num : nums) {
            //sum > 0代表前面的数字和都是大于0的，可以直接加下一个数
            if (sum > 0) {
                sum += num;
            } else {    //sum < 0代表前面的数字和是小于0的，直接从当前数字开始累加
                sum = num;
            }
            //sum = sum>0? sum + num :num;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
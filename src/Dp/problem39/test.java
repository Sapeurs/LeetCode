package Dp.problem39;

import java.util.Arrays;

/**
 * @author: Sapeurs
 * @date: 2021/7/31 20:10
 * @description:
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
    }
}


class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int res = 0;
        Arrays.fill(dp,1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    //表示在i之前的j位置上的数字加上nums[i]后的最长上升子序列
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
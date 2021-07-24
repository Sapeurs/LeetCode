package Array.problem5;

/**
 * @author: Sapeurs
 * @date: 2021/5/11 21:24
 * @description: 剑指offer 42.连续子数组的最大和
 * <p>
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums));
    }
}


class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return nums[0];
        int max = nums[0], sum = nums[0];
        for (int i = 1; i < len; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
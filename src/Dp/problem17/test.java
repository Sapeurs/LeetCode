package Dp.problem17;

import java.util.Arrays;

/**
 * @author: Sapeurs
 * @date: 2021/7/19 21:03
 * @description: 213. 打家劫舍 II
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都
 * 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的
 * 防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，
 * 今晚能够偷窃到的最高金额。
 */
public class test {
}

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, len - 1)),
                myRob(Arrays.copyOfRange(nums, 1, len)));
    }

    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num :
                nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}
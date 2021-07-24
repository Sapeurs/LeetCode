package Dp.problem18;

/**
 * @author: Sapeurs
 * @date: 2021/7/19 21:42
 * @description: 740. 删除并获得点数 (打家劫舍3)
 * <p>
 * 给你一个整数数组nums，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除
 * 所有等于nums[i] - 1 和 nums[i] + 1的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点
 */
public class test {
}


class Solution {
    public int deleteAndEarn(int[] nums) {
        int res = 0;
        for (int val :
                nums) {
            res = Math.max(res, val);
        }
        int[] sum = new int[res + 1];
        for (int val :
                nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    private int rob(int[] nums) {
        int len = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }
        return second;
    }
}
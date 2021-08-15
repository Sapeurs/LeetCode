package Dp.wiggleMaxLength;

/**
 * @author: Sapeurs
 * @date: 2021/8/1 20:59
 * @description: 376. 摆动序列
 *
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。
 * 第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素
 * 的序列也视作摆动序列。
 *
 *子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素
 * 保持其原始顺序。
 *
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 *
 */
public class test {
}



class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int[] up = new int[len];
        int[] down = new int[len];
        up[0] = down[0] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[len - 1], down[len - 1]);
    }

    //空间优化
    public int wiggleMaxLength1(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1])
                up = Math.max(up, down + 1);
            else if (nums[i] < nums[i-1])
                down = Math.max(down, up + 1);
        }
        return Math.max(up,down);
    }
}




















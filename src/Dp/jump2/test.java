package Dp.jump2;

/**
 * @author: Sapeurs
 * @date: 2021/7/20 20:27
 * @description: 45. 跳跃游戏 II
 * <p>
 * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4}));
    }
}


class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        //使用end记录某次跳跃的边界
        int end = 0;
        int rightMost = 0;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            //找能跳的最远的
            rightMost = Math.max(rightMost, i + nums[i]);
            //如果遇到边界，就更新边界，并且步数+1
            if (i == end) {
                end = rightMost;
                res++;
            }
        }
        return res;
    }
}
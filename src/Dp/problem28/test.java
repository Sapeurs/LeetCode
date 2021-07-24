package Dp.problem28;

/**
 * @author: Spaeurs
 * @date: 2021/7/24 20:13
 * @description: 42. 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
 * 计算按此排列的柱子，下雨之后能接多少雨水
 *
 */
public class test {
}


class Solution {
    //1.暴力法
    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 0; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            //寻找第i的元素左边的最大高度
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left,height[j]);
            }
            //寻找第i的元素右边的最大高度
            for (int j = i; j < size; j++) {
                max_right = Math.max(max_right,height[j]);
            }
            ans += Math.min(max_left,max_right) - height[i];
        }
        return ans;
    }

    //2.动态规划
    public int trap1(int[] height) {
        if (height == null || height.length == 0) return 0;
        int ans = 0;
        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        //存储第i个元素左边和右边的最大高度
        left_max[0] = height[0];
        for (int i = 1; i < size; i++) {
            left_max[i] = Math.max(height[i], left_max[i-1]);
        }
        right_max[size-1] = height[size-1];
        for (int i = size-2; i < 0; i--) {
            right_max[i] = Math.max(height[i],right_max[i+1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans+=Math.min(left_max[i], right_max[i]) - height[i];
        }
    }
}
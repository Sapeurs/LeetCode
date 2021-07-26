package Dp.problem28;

import java.util.Deque;
import java.util.LinkedList;

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
        for (int i = size-2; i > 0; i--) {
            right_max[i] = Math.max(height[i],right_max[i+1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans+=Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }

    //3.使用栈
    public int trap2(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> stack = new LinkedList<>();
        while (current< height.length){
            while (!stack.isEmpty()&&height[current]>height[stack.peek()]){
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int distance = current-stack.peek()-1;
                int bounded_height = Math.min(height[current],height[stack.peek()]) - height[top];
                ans += distance*bounded_height;
            }
            stack.push(current++);
        }
        return ans;
    }

    //4.双指针
    public int trap3(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            }else {
                if (height[right] >= right_max){
                    right_max = height[right];
                }else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }
}
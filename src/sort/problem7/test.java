package sort.problem7;

import java.util.Arrays;

/**
 * @author: Sapeurs
 * @date: 2021/4/3 21:45
 * @description: 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、
 * 面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 */
public class test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ans = {3, 2, 3, 4};
        System.out.println(solution.largestPerimeter(ans));
    }

}


class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = len - 1; i > 1; i--) {
            if (isAngle(nums[i], nums[i - 1], nums[i - 2]))
                return nums[i] + nums[i - 1] + nums[i - 2];
        }
        return 0;
    }

    boolean isAngle(int a, int b, int c) {
        return a + b > c && b + c > a && a + c > b;
    }
}


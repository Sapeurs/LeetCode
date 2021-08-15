package Array.singleNumbers;

import java.util.Arrays;

/**
 * @author: Sapeurs
 * @date: 2021/6/26 21:05
 * @description: 剑指offer 56-1.数组中数字出现的次数
 * <p>
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4, 2, 6, 4, 6, 7, 3, 8, 8, 2};
        System.out.println(Arrays.toString(solution.singleNumbers(arr)));
    }
}


class Solution {
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for (int num : nums)
            n ^= num;
        while ((n & m) == 0)
            m <<= 1;
        for (int num :nums) {
            if ((num & m) != 0)
                x ^= num;
            else y ^= num;
        }
        return new int[]{x, y};
    }
}
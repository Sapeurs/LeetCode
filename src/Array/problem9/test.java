package Array.problem9;

/**
 * @author: Sapeurs
 * @date: 2021/6/29 19:32
 * @description: 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 4, 3, 3};
        System.out.println(solution.singleNumber(arr));
    }
}


class Solution {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num :
                nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
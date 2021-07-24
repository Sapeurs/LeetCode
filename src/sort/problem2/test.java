package sort.problem2;


import java.util.Arrays;

/***
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 *
 */

public class test {
    public static void main(String[] args) {

    }
}


class Solution {
    public String minNumber(int[] nums) {
        int n = nums.length;
        if (n == 0) return "";
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (s1, s2) -> {
            if (s1.charAt(0) != s2.charAt(0)) return s1.charAt(0) - s2.charAt(0);
            return (s1 + s2).compareTo(s2 + s1);
        });
        String res = "";
        for (String str : strs) res += str;
        return res;
    }
}

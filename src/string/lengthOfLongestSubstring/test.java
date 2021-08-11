package string.lengthOfLongestSubstring;

/**
 * @author: Sapeurs
 * @date: 2021/5/10 21:24
 * @description: 剑指offer 48. 最长不含重复字符的子字符串
 * <p>
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0)
            return 0;
        if (len == 1)
            return 1;
        int max = 1;
        for (int i = 0, j = 1; j < len; j++) {
            for (int k = i; k < j; k++) {
                if (s.charAt(j) == s.charAt(k)) {
                    i = k + 1;
                    break;
                }
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
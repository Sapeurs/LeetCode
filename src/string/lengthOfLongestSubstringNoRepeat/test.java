package string.lengthOfLongestSubstringNoRepeat;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Spaeurs
 * @date: 2021/8/12 21:35
 * @description: 3. 无重复字符的最长子串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}


class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int res = 0;
        while (right<s.length()){
            char c = s.charAt(right);
            right++;
            //进行窗口内数据的更新
            window.put(c,window.getOrDefault(c, 0) + 1);

            //判断左侧窗口是否要收缩，当window.get[c] > 1时，说明存在重复字符，移动left缩小窗口 （重点）
            while (window.get(c) > 1){
                char d = s.charAt(left);
                left++;
                //进行窗口内数据的更新
                window.put(d, window.getOrDefault(d, 0) - 1);
            }

            //更新答案
            res = Math.max(res, right - left);
        }
        return res;
    }
}
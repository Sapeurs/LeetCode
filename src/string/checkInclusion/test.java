package string.checkInclusion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Spaeurs
 * @date: 2021/8/12 19:43
 * @description: 567. 字符串的排列
 * <p>
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 */
public class test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion("aab", "eidbaaooo"));
    }
}


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] chars = s1.toCharArray();
        for (char c : chars) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        //代表窗口内含有多少需要的数字，不包括重复的
        int valid = 0;
        while (right < s2.length()){
            char c = s2.charAt(right);
            right++;
            //更新窗口内的数据
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            //判断左侧窗口是否要收缩，当窗口大小大于s1时，就应该收缩（重点）
            while (right - left >= s1.length()){
                //在这里判断是否找到了合法的子串
                if (valid == need.size())
                    return true;
                char d = s2.charAt(left);
                left++;
                //更新窗口内的数据
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) -1);
                }
            }
        }
        return false;
    }
}
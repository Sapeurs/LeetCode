package string.minWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: Spaeurs
 * @date: 2021/8/11 20:09
 * @description: 76. 最小覆盖子串
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }
}


class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] chars = t.toCharArray();
        for (char c :
                chars) {
            need.put(c,need.getOrDefault(c,0)+1);
        }

        int left = 0, right = 0;
        //记录窗口中满足need条件的字符个数
        int valid = 0;
        //记录最小覆盖子串的起始索引和长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right<s.length()){
            //c是将被移入窗口的字符
            char c = s.charAt(right);
            //右移窗口
            right++;
            //进行窗口内数据的更新
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            //判断左侧窗口是否要收缩，如果valid和need.size()的大小相同，说明窗口满足条件，已完全覆盖了t
            while (valid == need.size()){
                //当前子串的长度小于len，说明找到更小的包含t的子串，更新最小覆盖子串
                if (right - left < len){
                    start = left;
                    len = right - left;
                }
                //d是将被移出窗口的字符
                char d = s.charAt(left);
                left++;
                //进行窗口内数据的更新
                if (need.containsKey(d)){
                    //如果window中移除的这个数据在need里面，将valid-1
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    if (window.get(d)>1)
                        window.put(d, window.get(d) -1);
                    else
                        window.remove(d);
                }
            }
        }
        return len == Integer.MAX_VALUE? "": s.substring(start,start + len);
    }
}
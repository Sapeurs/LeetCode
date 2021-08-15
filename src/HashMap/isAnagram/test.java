package HashMap.isAnagram;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/***
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class test {
    public static void main(String[] args) {
        String s = "a", t = "b";
        Solution solution = new Solution();
        System.out.println(solution.isAnagram(s, t));
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Map<Character, Integer> scMap = new HashMap<>();
        Map<Character, Integer> tcMap = new HashMap<>();
        for (char s1 : sc
        ) {
            scMap.put(s1, scMap.containsKey(s1) ? scMap.get(s1) + 1 : 1);
        }
        for (char s1 : tc
        ) {
            tcMap.put(s1, tcMap.containsKey(s1) ? tcMap.get(s1) + 1 : 1);
        }
        Set<Character> set1 = scMap.keySet();
        Set<Character> set2 = tcMap.keySet();
        if (set1.size() != set2.size()) {
            return false;
        }
        if (set1.containsAll(set2)) {
            for (Character key1 : scMap.keySet()
            ) {
                if (scMap.get(key1) != tcMap.get(key1)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}


/***
 * t 是 ss 的异位词等价于「两个字符串排序后相等」。因此我们可以对字符串 ss 和 tt 分别排序，
 * 看排序后的字符串是否相等即可判断。此外，如果 ss 和 tt 的长度不同，tt 必然不是 ss 的异位词。
 *
 */

class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}


/***
 * tt 是 ss 的异位词等价于「两个字符串中字符出现的种类和次数均相等」。由于字符串只包含 2626 个小写字母，
 * 因此我们可以维护一个长度为 2626 的频次数组 {table}table，先遍历记录字符串 ss 中字符出现的频次，
 * 然后遍历字符串 tt，减去 {table}table 中对应的频次，如果出现 {table}[i]<0table[i]<0，
 * 则说明 tt 包含一个不在 ss 中的额外字符，返回 {false}false 即可。
 */

class Solution3 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
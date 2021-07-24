package HashMap.problem6;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abaccdeff";
        System.out.println(solution.firstUniqChar(s));
    }
}


/***
 * 遍历字符串 s ，使用哈希表统计 “各字符数量是否 >1 ”。
 * 再遍历字符串 s ，在哈希表中找到首个 “数量为 1 的字符”，并返回
 */
class Solution {
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Boolean> dic = new HashMap<>();
        for (char c : chars
        ) {
            dic.put(c, !dic.containsKey(c));
        }
        for (char c : chars
        ) {
            if (dic.get(c)) return c;
        }
        return ' ';
    }

}

class Solution2 {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc)
            dic.put(c, !dic.containsKey(c));
        for (Map.Entry<Character, Boolean> d : dic.entrySet()) { //Map.Entry:获得map的key value两个值
            if (d.getValue()) return d.getKey();
        }
        return ' ';
    }
}
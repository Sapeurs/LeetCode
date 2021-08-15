package HashMap.maxNumberOfBalloons;

import java.util.HashMap;
import java.util.Map;


/**
 * 1189. “气球” 的最大数量
 *
 * 给你一个字符串text，你需要使用 text 中的字母来拼凑
 * 尽可能多的单词"balloon"（气球）。
 *
 * 字符串text 中的每个字母最多只能被使用一次。请你返回
 * 最多可以拼凑出多少个单词"balloon"。
 *
 */

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String text = "nlaebolko";
        System.out.println(solution.maxNumberOfBalloons(text));
    }
}


class Solution {
    public int maxNumberOfBalloons(String text) {
        char[] texts = text.toCharArray();
        Map<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('b', 0);
        hashMap.put('a', 0);
        hashMap.put('l', 0);
        hashMap.put('o', 0);
        hashMap.put('n', 0);
        for (int i = 0; i < texts.length; i++) {
            if (texts[i] == 'b' || texts[i] == 'a' || texts[i] == 'l' || texts[i] == 'o' || texts[i] == 'n') {
                hashMap.put(texts[i], hashMap.get(texts[i]) + 1);
            }
        }

        hashMap.put('o', hashMap.get('o') / 2);
        hashMap.put('l', hashMap.get('l') / 2);

        int num = 10000;

        for (Integer i : hashMap.values()) {
            if (i < num) {
                num = i;
            }
        }
        return num;
    }
}
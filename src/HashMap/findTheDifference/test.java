package HashMap.findTheDifference;

import java.util.Arrays;

/***
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母
 */
public class test {

}


class Solution {
    public char findTheDifference(String s, String t) {
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        if (str1.length == 0) {
            return str2[0];
        }
        Arrays.sort(str1);
        Arrays.sort(str2);
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] != str2[i]) {
                return str2[i];
            }
        }
        return str2[str2.length - 1];
    }
}

/***
 * 将字符串 s 中每个字符的 ASCII 码的值求和，得到 A_s,对字符串 t 同样的方法得到 A_t。
 * 两者的差值 A_t-A_s即代表了被添加的字符。
 */

class Solution1 {
    public char findTheDifference(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }
}
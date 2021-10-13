package Test.minsheng;

/**
 * @author: Spaeurs
 * @date: 2021/10/9 19:33
 * @description:
 */
public class Main1 {
}

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @param t string字符串
     * @return int整型
     */
    public int answerSheet (String s, String t) {
        // write code here
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == 'A' && s.charAt(4*i) == '1' && s.charAt(4*i + 1) == '0'
            &&s.charAt(4*i + 2) == '0'&&s.charAt(4*i + 3) == '0'){
                    count++;
            }
            if (t.charAt(i) == 'B' && s.charAt(4*i + 1) == '1'&& s.charAt(4*i) == '0'
                    && s.charAt(4*i + 2) == '0'&& s.charAt(4*i + 3) == '0'){
                    count++;
            }
            if (t.charAt(i) == 'C' && s.charAt(4*i + 2) == '1'&& s.charAt(4*i) == '0'
                    && s.charAt(4*i + 1) == '0'&& s.charAt(4*i + 3) == '0'){
                    count++;
            }
            if (t.charAt(i) == 'D' && s.charAt(4*i + 3) == '1'&& s.charAt(4*i ) == '0'
                    && s.charAt(4*i + 1) == '0'&& s.charAt(4*i + 2) == '0'){
                    count++;
            }
        }
        return count;
    }
}
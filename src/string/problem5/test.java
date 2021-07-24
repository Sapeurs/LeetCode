package string.problem5;

/**
 * @author: Sapeurs
 * @date: 2021/6/27 21:17
 * @description: 剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
 * 则输出"student. a am I"。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "      hello    world!  ";
        System.out.println(solution.reverseWords1(s));
    }
}


class Solution {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        int n = split.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = n - 1; i >= 0; i--) {
            if (!split[i].equals("")) {
                stringBuffer.append(split[i]);
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString().trim();
    }

    //双指针
    public String reverseWords1(String s) {
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            res.append(s, i + 1, j + 1).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return res.toString().trim();
    }
}
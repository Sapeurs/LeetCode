package string.reverseLeftWords;

/**
 * @author: Sapeurs
 * @date: 2021/5/10 21:07
 * @description: 剑指offer 58.左旋转字符串
 *
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseLeftWords("lrloseumgh", 0));
    }
}


class Solution {
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        if (len == 1)
            return s;
        return s.substring(n, len).concat(s.substring(0, n));
    }

    //若面试规定不允许使用切片函数，则使用此方法
    public String reverseLeftWords1(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            res.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}
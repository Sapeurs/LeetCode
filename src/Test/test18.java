package Test;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/8/21 15:58
 * @description:
 */
public class test18 {
    public static void main(String[] args) {

    }
}

class Solution01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 返回Sn的第k位字符
     * @param n int整型 Sn的n
     * @param k int整型 需要返回的字符下标位
     * @return char字符型
     */
    public char findKthBit (int n, int k) {
        // write code here
        char[] chars = new char[27];
        for (int i = 0; i < 27; i++) {
            chars[i] = (char) ('a' + i - 1);
        }
        String[] strings = new String[n + 1];
        strings[1] = "a";
        for (int i = 2; i <= n; i++) {
            strings[i] = strings[i-1] + chars[i] + invert(strings[i-1]);
        }
        return strings[n].charAt(k-1);
    }

    String invert(String s){
        StringBuilder reverse = new StringBuilder();
        for (char c: s.toCharArray()) {
            char c1 = (char) ('z' - (c - 'a'));
            reverse.append(c1);
        }
        return reverse.reverse().toString();
    }
}
package Test;

import java.util.ArrayList;

/**
 * @author: Sapeurs
 * @date: 2021/5/8 15:32
 * @description:
 */
public class test7 {


    public int specialStr(String inputStr, char[] cList) {
        int max = 0;
        char[] c = inputStr.toCharArray();

        ArrayList<Character> list = new ArrayList<>();
        for (char a :
                c) {
            list.add(a);
        }
        for (int i = 0; i < c.length; i++) {
            if (i < c.length - 1 && c[i] == c[i + 1] && !list.contains(c[i])) {
                int len = 2, left = i - 1, right = i + 2;
                while (left >= 0 && right < c.length && c[left] == c[right] && !list.contains(c[left])) {
                    len += 2;
                    left--;
                    right++;
                }
                max = Math.max(max, len);
            }
            if (i > 0 && i < c.length - 1 && c[i - 1] == c[i + 1] && !list.contains(c[i]) && !list.contains(c[i - 1])) {
                int len = 3, left = i - 2, right = i + 2;
                while (left >= 0 && right < c.length && c[left] == c[right] && !list.contains(c[left])) {
                    len += 2;
                    left--;
                    right++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
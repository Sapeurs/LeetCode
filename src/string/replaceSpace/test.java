package string.replaceSpace;

/**
 * @author: Sapeurs
 * @date: 2021/5/11 21:56
 * @description: 剑指offer 05.替换空格
 * <p>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.replaceSpace("We are happy"));
    }
}

class Solution {
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    //使用StringBuilder
    public String replaceSpace1(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c :
                s.toCharArray()) {
            if (c == ' ')
                stringBuilder.append("%20");
            else
                stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
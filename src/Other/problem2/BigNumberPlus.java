package Other.problem2;

/**
 * @author: Sapeurs
 * @date: 2021/3/30 12:37
 * @description: 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 */
public class BigNumberPlus {

    public static void main(String[] args) {

        System.out.println(solve("789", "987"));
    }

    public static String solve(String s, String t) {
        StringBuffer stringBuffer = new StringBuffer();
        //carry为进位
        int i = s.length() - 1, j = t.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : s.charAt(i--) - '0';
            int y = j < 0 ? 0 : t.charAt(j--) - '0';
            int sum = x + y + carry;
            stringBuffer.append(sum % 10);
            carry = sum / 10;
        }
        return stringBuffer.reverse().toString();
    }

}
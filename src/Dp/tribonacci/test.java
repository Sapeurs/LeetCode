package Dp.tribonacci;

/**
 * @author: Sapeurs
 * @date: 2021/7/14 19:43
 * @description: 1137. 第 N 个泰波那契数
 * <p>
 * 泰波那契序列Tn定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
 */
public class test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.tribonacci(25));
    }
}


class Solution {
    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) return 1;
        int a = 0, b = 1, c = 1, res = 0;
        for (int i = 2; i < n; i++) {
            res = a + b + c;
            a = b;
            b = c;
            c = res;
        }
        return res;
    }
}
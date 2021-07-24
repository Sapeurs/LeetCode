package Dp.problem14;

/**
 * @author: Sapeurs
 * @date: 2021/7/14 19:31
 * @description: 509. 斐波那契数
 * <p>
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和
 * <p>
 * 给你 n ，请计算 F(n) 。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(5));
    }
}


class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0, b = 1, res = 0;
        for (int i = 1; i < n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
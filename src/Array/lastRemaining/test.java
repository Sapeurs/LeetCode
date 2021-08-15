package Array.lastRemaining;

/**
 * @author: Sapeurs
 * @date: 2021/3/25 20:57
 * @description:  剑指 Offer 62. 圆圈中最后剩下的数字
 * 0, 1,···,n-1这n个数字排成一个圆圈，从数字0开始，
 * 每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
 * 求出这个圆圈里剩下的最后一个数字。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastRemaining(8, 3));
    }
}


class Solution {
    public int lastRemaining(int n, int m) {
        int pos = 0; // 最终活下来那个人的初始位置
        for (int i = 2; i <= n; i++) {
            pos = (pos + m) % i;  // 每次循环右移
        }
        return pos;
    }
}
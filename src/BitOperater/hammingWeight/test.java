package BitOperater.hammingWeight;

/**
 * @author: Sapeurs
 * @date: 2021/5/15 15:07
 * @description: 剑指offer 15. 二进制中1的个数
 * <p>
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
 * 例如，把9表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(00000000000000000000000000001011));
    }
}


class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            //若 n & 1 = 0 ，则 n 二进制 最右一位 为 0
            //若 n & 1 = 1 ，则 n 二进制 最右一位 为 1
            res += n & 1;
            //无符号右移一位
            n >>>= 1;
        }
        return res;
    }

    public int hammingWeight1(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
}
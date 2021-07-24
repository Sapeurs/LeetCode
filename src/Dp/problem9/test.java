package Dp.problem9;

/**
 * @author: Sapeurs
 * @date: 2021/5/3 19:46
 * @description: 剑指offer 14.剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(8));
    }
}


class Solution {
    public int cuttingRope(int n) {
        //dp[i]表示长度为i的绳子剪成m段后的最大乘积
        int[] dp = new int[n + 1];
        //初始化 dp[2] = 1 表示如果一个绳子长度为2必然只能分成两段长度为1的绳子，两者乘积为1
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            //j表示要剪下的长度，如果剪掉的长度为1，则对最后的乘积无任何增益，所以从2开始剪
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(Math.max(dp[i - j], i - j) * j, dp[i]);
            }
        }
        return dp[n];
    }
}
package Dp.problem31;

/**
 * @author: Spaeurs
 * @date: 2021/7/26 20:21
 * @description: 96. 不同的二叉搜索树
 */
public class test {
}



class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        //dp[i]表示以i为根节点的不同二叉搜索树的个数
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //dp[i]的值等于左子树的个数加上右子树的个数  循环累加
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
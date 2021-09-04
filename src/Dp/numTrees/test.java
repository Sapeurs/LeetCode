package Dp.numTrees;

/**
 * @author: Spaeurs
 * @date: 2021/7/26 20:21
 * @description: 96. 不同的二叉搜索树
 *
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的
 * 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
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

    //穷举
    public int numTrees1(int n) {
        return count(1,n);
    }
    /* 计算闭区间[lo,hi]组成的BST个数*/
    int count(int lo, int hi){
        if (lo>hi) return 1;
        int res = 0;
        for (int i = lo; i <= hi; i++) {
            //i的值作为根节点root
            int left = count(lo,i-1);
            int right = count(i+1,hi);
            //左右子树的组合数乘积就是BST的总数
            res += left*right;
        }
        return res;
    }
}
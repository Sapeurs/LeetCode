package Tree.generateTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Spaeurs
 * @date: 2021/9/4 21:17
 * @description: 95. 不同的二叉搜索树 II
 * <p>
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n
 * 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateTrees(3).toString());
    }
}


class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return build(1,n);
    }

    //穷举
    List<TreeNode> build(int lo, int hi) {
        List<TreeNode> res = new LinkedList<>();
        if (lo > hi) {
            res.add(null);
            return res;
        }
        //1. 穷举root节点的所有可能
        for (int i = lo; i <= hi; i++) {
            //2、递归构造出左右子树的所有合法BST
            List<TreeNode> leftTrees = build(lo, i - 1);
            List<TreeNode> rightTrees = build(i + 1, hi);
            for (TreeNode left :leftTrees) {
                for (TreeNode right :rightTrees) {
                    //i作为根节点root的值
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
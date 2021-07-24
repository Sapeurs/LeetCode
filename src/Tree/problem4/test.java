package Tree.problem4;

import java.util.Stack;

/**
 * @author: Sapeurs
 * @date: 2021/4/8 8:45
 * @description: 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 */
public class test {
}


class Solution {
    //递归
    int ans;

    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        for (int i = low; i <= high; i++) {
            TreeNode temp = root;
            while (temp != null && temp.val != i)
                temp = temp.val > i ? temp.left : temp.right;
            if (temp != null)
                sum += temp.val;
        }
        return sum;
    }

    public int rangeSumBST1(TreeNode root, int low, int high) {
        ans = 0;
        dfs(root, low, high);
        return ans;
    }

    public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R)
                ans += node.val;
            if (L < node.val)
                dfs(node.left, L, R);
            if (node.val < R)
                dfs(node.right, L, R);
        }
    }

    //迭代
    public int rangeSumBST2(TreeNode root, int low, int high) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (low <= node.val && node.val <= high)
                    ans += node.val;
                if (low < node.val)
                    stack.push(node.left);
                if (node.val < high)
                    stack.push(node.right);
            }
        }
        return ans;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
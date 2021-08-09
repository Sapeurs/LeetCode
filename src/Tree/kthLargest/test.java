package Tree.kthLargest;

/**
 * @author: Sapeurs
 * @date: 2021/4/8 22:19
 * @description: 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class test {
}


class Solution {
    int count = 0, res = 0;

    public int kthLargest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) //root为空，直接返回
            return;
        dfs(root.right);
        if (count == 0) return;//已经找到res时，直接返回
        if (--count == 0) res = root.val;//先--，再判断
        dfs(root.left);
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
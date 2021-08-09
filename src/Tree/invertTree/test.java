package Tree.invertTree;

/**
 * @author: Sapeurs
 * @date: 2021/4/5 21:47
 * @description: 226. 翻转二叉树
 * 翻转一棵二叉树。
 */
public class test {
}


class Solution {
    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;
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

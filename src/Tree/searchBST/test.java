package Tree.searchBST;

/**
 * @author: Sapeurs
 * @date: 2021/4/7 21:43
 * @description: 700. 二叉搜索树中的搜索
 * 给定二叉搜索树（BST）的根节点和一个值。
 * 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。
 * 如果节点不存在，则返回 NULL。
 */
public class test {
}


class Solution {

    //递归
    public TreeNode searchBST(TreeNode root, int val) {

/*
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        else if (root.val>val)
           return searchBST(root.left,val);
        else
           return searchBST(root.right, val);
*/

        if (root == null || val == root.val)
            return root;
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);

    }

    //迭代
    public TreeNode searchBST1(TreeNode root, int val) {
        while (root != null && val != root.val)
            root = val < root.val ? root.left : root.right;
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

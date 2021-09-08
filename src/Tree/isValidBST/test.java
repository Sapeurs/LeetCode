package Tree.isValidBST;

/**
 * @author: Spaeurs
 * @date: 2021/9/4 19:31
 * @description: 98. 验证二叉搜索树
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 */
public class test {
}




class Solution {
    public boolean isValidBST(TreeNode root) {
        return validBST(root,null,null);
    }

    boolean validBST(TreeNode root, TreeNode max, TreeNode min){
        if (root == null) return true;
        if (max != null && root.val >= max.val) return false;
        if (min != null && root.val <= min.val) return false;
        return validBST(root.left,root,min) && validBST(root.right,max,root);
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
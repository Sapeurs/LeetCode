package Tree.convertBST;

/**
 * @author: Spaeurs
 * @date: 2021/9/4 16:09
 * @description: 538. 把二叉搜索树转换为累加树
 *
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node的新值等于原树中大于或等于node.val的值之和。
 *
 */
public class test {
}

class Solution {
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    int sum = 0;

    void traverse(TreeNode root){
        if (root == null)
            return;
        traverse(root.right);
        root.val +=sum;
        sum = root.val;
        traverse(root.left);
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
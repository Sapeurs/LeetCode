package Tree.deleteNode;

/**
 * @author: Spaeurs
 * @date: 2021/9/4 16:48
 * @description: 450. 删除二叉搜索树中的节点
 *
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 *
 */
public class test {
}



class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key){
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            //左右子树都不为空，找到右子树中最小的节点来替换root
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            //转而去删除minNode.val
            root.right = deleteNode(root.right, minNode.val);
        }else if (root.val < key)
            root.right = deleteNode(root.right,key);
        else
            root.left = deleteNode(root.left,key);

        return root;
    }

    TreeNode getMin(TreeNode node){
        while (node.left != null) node = node.left;
        return node;
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
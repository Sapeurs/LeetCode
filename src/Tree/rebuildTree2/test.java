package Tree.rebuildTree2;

import java.util.HashMap;

/**
 * @author: Spaeurs
 * @date: 2021/8/19 20:44
 * @description: 106. 从中序与后序遍历序列构造二叉树
 * <p>
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 */
public class test {
}


class Solution {

    int[] postorder;
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recur(postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode recur(int root, int left, int right){
        if (left>right) return null;
        TreeNode node = new TreeNode(postorder[root]);

        int i = dic.get(postorder[root]);
        node.left = recur(root - right + i - 1, left, i - 1);
        node.right = recur(root - 1,i + 1, right);
        return node;
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

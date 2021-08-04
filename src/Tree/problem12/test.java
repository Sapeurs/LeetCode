package Tree.problem12;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Sapeurs
 * @date: 2021/7/8 19:30
 * @description: 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 */
public class test {
}


class Solution {

    int[] preOrder;
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    /**
     * @param root  根节点在前序遍历的索引
     * @param left  子树在中序遍历的左边界
     * @param right 子树在中序遍历的右边界
     * @return
     */
    TreeNode recur(int root, int left, int right) {
        if (left > right) return null;
        TreeNode node = new TreeNode(preOrder[root]);//建立根节点
        //根据根节点在前序遍历中的索引获取中序遍历中的索引
        int i = dic.get(preOrder[root]);//划分根节点、左子树、右子树

        //左子树的根节点就是左子树在前序遍历中的第一个 索引：root+1，左边边界就是left，右边边界是根节点在中序遍历中的索引i减去1
        node.left = recur(root + 1, left, i - 1);//开启左子树递归

        /*
        右子树的根节点就是右子树在前序遍历中的第一个，即当前根节点加上左子树的数量
        左子树的长度=左子树的右边-左边 (i - 1 - left + 1) 最后再+1就是右子树的根在前序遍历中的索引
         */
        node.right = recur(root + i - left + 1, i + 1, right);//开启右子树递归
        return node;
    }
}


class Solution1{

    int[] preorder;
    Map<Integer,Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i],i);
        }
        return recur(0,0, inorder.length-1);
    }

    public TreeNode recur(int root, int left, int right){
        if (left>right) return null;
        TreeNode node = new TreeNode(preorder[root]);

        Integer i = dic.get(preorder[root]);
        node.left = recur(root + 1, left, i - 1);
        node.right = recur(i - left + 1 + root,i+1,right);
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

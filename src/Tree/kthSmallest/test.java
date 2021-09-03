package Tree.kthSmallest;

/**
 * @author: Spaeurs
 * @date: 2021/9/3 21:54
 * @description: 230. 二叉搜索树中第K小的元素
 *
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法
 * 查找其中第 k 个最小元素（从 1 开始计数）。
 *
 */
public class test {
}

class Solution {

    public int kthSmallest(TreeNode root, int k) {
      //利用BST的中序遍历
        return 0;
    }

    //记录当前元素的排名
    int rank = 0;
    //记录结果
    int res = 0;

    void traverse(TreeNode root, int k){
        if (root == null) return;
        traverse(root.left, k);
        rank++;
        if (k == rank){

        }
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
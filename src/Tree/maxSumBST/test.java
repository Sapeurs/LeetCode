package Tree.maxSumBST;

/**
 * @author: Spaeurs
 * @date: 2021/9/6 20:30
 * @description: 1373. 二叉搜索子树的最大键值和
 *
 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 *
 */
public class test {
}


class Solution {

    //记录BST最大节点之和
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    /*
    函数返回int[]{isBST, min, max, sum}
     */
    int[] traverse(TreeNode root){
        //base case
        if (root == null){
            return new int[]{1,Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        }

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        //后续遍历位置
        int[] res = new int[4];
        //判断以root为根的二叉树是不是BST
        if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]){
            res[0] = 1;
            //计算以root为根的这颗BST的最小值
            res[1] = Math.min(left[1], root.val);
            //计算以root为根的这颗BST的最大值
            res[2] = Math.max(right[2], root.val);
            //计算以root为根的这颗BST的所有节点之和
            res[3] = root.val + left[3] + right[3];
            //更新全局变量
            maxSum = Math.max(maxSum,res[3]);
        }else //以root为根的二叉树不是BST
            res[0] = 0;
        return res;
    }
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

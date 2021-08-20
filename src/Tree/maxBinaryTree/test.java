package Tree.maxBinaryTree;

/**
 * @author: Spaeurs
 * @date: 2021/8/19 19:06
 * @description: 654. 最大二叉树
 * <p>
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 * <p>
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * <p>
 * 返回有给定数组 nums 构建的 最大二叉树 。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
    }
}


class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length-1);
    }

    TreeNode construct(int[] nums, int start, int end){
        if(nums.length == 0 || start > end) return null;
        int max = 0, index = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] >= max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = construct(nums,start,index-1);
        node.right = construct(nums,index+1,end);
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

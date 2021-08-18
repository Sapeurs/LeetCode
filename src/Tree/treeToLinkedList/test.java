package Tree.treeToLinkedList;

/**
 * @author: Spaeurs
 * @date: 2021/8/18 21:11
 * @description: 114. 二叉树展开为链表
 * <p>
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，
 * 而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class test {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2,node3,node4);
        TreeNode node5 = new TreeNode(5,null,node6);
        TreeNode node1 = new TreeNode(1,node2,node5);

        Solution solution = new Solution();
        solution.flatten(node1);

    }
}


class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        flatten(root.left);
        flatten(root.right);
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        
        //将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null){
            p = p.right;
        }
        p.right = right;
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

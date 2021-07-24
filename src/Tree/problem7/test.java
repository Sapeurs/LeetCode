package Tree.problem7;

/**
 * @author: Sapeurs
 * @date: 2021/4/11 21:31
 * @description: 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
 * 否则不为 NULL 的节点将直接作为新二叉树的节点。
 */
public class test {
}


class Solution {

//    TreeNode root;
//
//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//
//        if (root1 == null && root2 == null)
//            return null;
//        if (root1 == null)
//            root.val = root2.val;
//        else if (root2 == null)
//            root.val = root1.val;
//        else
//            root.val = root1.val + root2.val;

//        mergeTrees(root1.left,root2.left);
//        mergeTrees(root1.right,root2.right);
//
//         return root;
//    }


    //深度优先搜索
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        TreeNode ans = new TreeNode(root1.val + root2.val);
        ans.left = mergeTrees(root1.left, root2.left);
        ans.right = mergeTrees(root1.right, root2.right);
        return ans;
    }

//    LinkedList<Integer> list;
//
//    public List<Integer> inorderTraversal(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//
//        while (root != null || !stack.isEmpty()){
//            while (root != null){
//                stack.push(root);
//                root = root.left;
//            }
//
//            if (!stack.isEmpty()){
//                root = stack.pop();
//                list.add(root.val);
//                root = root.right;
//            }
//        }
//
//        return list;
//    }

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
package Tree.levelOrder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Sapeurs
 * @date: 2021/7/6 19:17
 * @description: 剑指 Offer 32 - I. 从上到下打印二叉树
 * <p>
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class test {

}


class Solution {

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            list.add(node.val);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        return list.stream().mapToInt(integer -> integer).toArray();
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

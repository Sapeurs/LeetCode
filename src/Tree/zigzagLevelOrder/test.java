package Tree.zigzagLevelOrder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Spaeurs
 * @date: 2021/9/21 21:34
 * @description: 103. 二叉树的锯齿形层序遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 */
public class test {

}


class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) deque.add(root);
        while (!deque.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.removeFirst();
                tmp.add(node.val);
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            list.add(tmp);
            if (deque.isEmpty()) return list;
            tmp = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.removeLast();
                tmp.add(node.val);
                if (node.left != null) deque.addFirst(node.left);
                if (node.right != null) deque.addFirst(node.right);
            }
            list.add(tmp);
        }
        return list;
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
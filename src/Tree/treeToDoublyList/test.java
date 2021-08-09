package Tree.treeToDoublyList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Sapeurs
 * @date: 2021/7/9 20:07
 * @description: 剑指 Offer 36. 二叉搜索树与双向链表
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class test {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node4.left = node2;
        node4.right = node5;
        node2.left = node1;
        node2.right = node3;
        new Solution().treeToDoublyList(node4);
    }
}


class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        List<Node> list = new ArrayList<>();
        midOrder(root, list);
        int n = list.size();
        for (int i = 0; i < n; i++) {
            list.get(i).right = list.get((i + 1) % n);
            if (i != 0) {
                list.get(i).left = list.get(i - 1);
            }
        }
        list.get(0).left = list.get(n - 1);
        return list.get(0);
    }

    void midOrder(Node root, List<Node> list) {
        if (root == null)
            return;
        midOrder(root.left, list);
        list.add(root);
        midOrder(root.right, list);
    }


    //dfs
    Node pre, head;

    public Node treeToDoublyList1(Node root) {
        if (root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);
        if (pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

}


class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

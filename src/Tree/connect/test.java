package Tree.connect;

/**
 * @author: Spaeurs
 * @date: 2021/8/18 20:44
 * @description: 116. 填充每个节点的下一个右侧节点指针
 *
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点
 *
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个
 * 右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有next 指针都被设置为 NULL。
 *
 *
 */
public class test {
}

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        connectTwoNodes(root.left,root.right);
        return root;
    }

    //辅助函数
    void connectTwoNodes(Node node1, Node node2){
        if (node1 == null || node2 == null) return;

        /*前序遍历位置*/
        //将传入的两个节点连接
        node1.next = node2;

        //连接相同父节点的两个子节点
        connectTwoNodes(node1.left,node1.right);
        connectTwoNodes(node2.left,node2.right);

        //连接跨越父节点的两个子节点
        connectTwoNodes(node1.right,node2.left);
    }


    public Node connect1(Node root) {
        if (root == null) return null;

        if (root.left != null){
            root.left.next = root.right;
            if (root.next != null)
                root.right.next = root.next.left;
        }

        connect1(root.left);
        connect1(root.right);

        return root;
    }
}



// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


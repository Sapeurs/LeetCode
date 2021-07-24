package Linked.problem9;

import java.util.HashMap;

/**
 * @author: Sapeurs
 * @date: 2021/6/24 19:38
 * @description: 剑指offer35. 复杂链表的复制
 * <p>
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
 * 每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针
 * 指向链表中的任意节点或者 null。
 */
public class test {
    public static void main(String[] args) {
        Node[] nodes = new Node[5];
        for (int i = 0; i < 5; i++) {
            nodes[i] = new Node();
        }
        for (int i = 1; i < 5; i++) {
            nodes[i - 1].next = nodes[i];
        }
        nodes[0].val = 7;
        nodes[1].val = 13;
        nodes[2].val = 11;
        nodes[3].val = 10;
        nodes[4].val = 1;
        nodes[1].random = nodes[0];
        nodes[2].random = nodes[3];
        nodes[3].random = nodes[2];
        nodes[4].random = nodes[0];

        Solution solution = new Solution();
        System.out.println(solution.copyRandomList1(nodes[0]).toString());
    }
}


class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        //复制各节点，并建立“原节点==》新节点”的Map映射
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        //构建新链表的next和random指向
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        //返回新链表的头结点
        return map.get(head);
    }

    public Node copyRandomList1(Node head) {
        if (head == null)
            return null;
        Node cur = head;
        //复制各节点，并构建拼接链表
        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        //构建各新节点的random指向
        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        //拆分两链表
        cur = head.next;
        Node pre = head, res = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        return res;
    }
}


class Node {
    int val;
    Node next;
    Node random;

    Node() {
    }

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

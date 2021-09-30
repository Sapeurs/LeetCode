package Linked.middleNode;

/**
 * @author: Spaeurs
 * @date: 2021/9/26 21:13
 * @description: 876. 链表的中间结点
 * <p>
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class test {
    public static void main(String[] args) {
        ListNode[] node1 = new ListNode[6];

        for (int i = 0; i < 6; i++) {
            node1[i] = new ListNode();
        }
        for (int i = 1; i < 6; i++) {
            node1[i - 1].next = node1[i];
        }
        node1[0].val = 1;
        node1[1].val = 2;
        node1[2].val = 3;
        node1[3].val = 4;
        node1[4].val = 5;
        node1[5].val = 6;
        System.out.println(new Solution().middleNode(node1[0]).val);
    }
}


class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
}
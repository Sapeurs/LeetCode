package Linked.addTwoNumbers;

/**
 * @author: Sapeurs
 * @date: 2021/4/15 19:34
 * @description:
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，
 * 并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 */
public class test {

    public static void main(String[] args) {
        ListNode[] node1 = new ListNode[3];
        ListNode[] node2 = new ListNode[3];

        for (int i = 0; i < 3; i++) {
            node1[i] = new ListNode();
            node2[i] = new ListNode();
        }
        for (int i = 1; i < 3; i++) {
            node1[i - 1].next = node1[i];
            node2[i - 1].next = node2[i];
        }
        node1[0].val = 2;
        node1[1].val = 4;
        node1[2].val = 4;
        node2[0].val = 5;
        node2[1].val = 6;
        node2[2].val = 4;
        Solution solution = new Solution();
        ListNode node = solution.addTwoNumbers(node1[0], node2[0]);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}


class Solution {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
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

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


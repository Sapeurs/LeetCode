package Linked.reorderList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Spaeurs
 * @date: 2021/9/26 20:23
 * @description: 143. 重排链表
 * <p>
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0→ L1→ … → Ln-1→ Ln
 * 请将其重新排列后变为：
 * <p>
 * L0→Ln→L1→Ln-1→L2→Ln-2→ …
 * <p>
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class test {
    public static void main(String[] args) {
        ListNode[] node1 = new ListNode[5];

        for (int i = 0; i < 4; i++) {
            node1[i] = new ListNode();
        }
        for (int i = 1; i < 4; i++) {
            node1[i - 1].next = node1[i];
        }
        node1[0].val = 1;
        node1[1].val = 2;
        node1[2].val = 3;
        node1[3].val = 4;
        //node1[4].val = 5;
        new Solution().reorderList1(node1[0]);
    }
}


class Solution {
    //双端队列
    public void reorderList(ListNode head) {
        if (head == null) return;
        Deque<ListNode> deque = new LinkedList<>();
        ListNode tmp = head.next;
        while (tmp != null) {
            deque.addLast(tmp);
            tmp = tmp.next;
        }
        ListNode pre = head, cur;
        boolean flag = true;
        while (!deque.isEmpty()) {
            if (flag) {
                cur = deque.removeLast();
            } else {
                cur = deque.removeFirst();
            }
            pre.next = cur;
            pre = pre.next;
            flag = !flag;
        }
        pre.next = null;
    }

    //寻找链表中点+链表逆序+合并链表
    public void reorderList1(ListNode head) {
        if (head == null) return;
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1,l2);
    }

    public ListNode middleNode(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public void mergeList(ListNode l1, ListNode l2){
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null){
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
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

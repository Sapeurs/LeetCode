package Linked.reverseList;

/**
 * @author: Sapeurs
 * @date: 2021/4/13 22:16
 * @description: 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class test {

    public static void main(String[] args) {
        ListNode[] node = new ListNode[5];
        for (int i = 0; i < 5; i++) {
            node[i] = new ListNode(i + 1);
        }
        for (int i = 1; i < 5; i++) {
            node[i - 1].next = node[i];
        }
        Solution solution = new Solution();
        ListNode kth = solution.reverseList(node[0]);
        System.out.println(kth.val);

    }

}


class Solution {

    //递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }


    //迭代
    public ListNode reverseList1(ListNode head) {
        ListNode cur = null, pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}



package Linked.problem2;

/**
 * @author: Sapeurs
 * @date: 2021/4/13 21:30
 * @description: 剑指 Offer 22. 链表中倒数第k个节点
 * <p>
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。
 * 这个链表的倒数第 3 个节点是值为 4 的节点。
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
        ListNode kth = solution.getKthFromEnd1(node[0], 2);
        System.out.println(kth.val);
    }

}


class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int i = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            i++;
        }
        for (int j = 0; j < i - k; j++) {
            head = head.next;
        }
        return head;
    }

    //双指针算法，不用统计链表长度
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++) {
            former = former.next;
        }
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }

    //加变量t，代替第一个for循环
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode slow = head, fast = head;
        int t = 0;
        while (fast != null) {
            if (t >= k) slow = slow.next;
            fast = fast.next;
            t++;
        }
        return slow;
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
    }
}
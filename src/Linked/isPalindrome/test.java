package Linked.isPalindrome;

/**
 * @author: Spaeurs
 * @date: 2021/8/31 21:11
 * @description: 234. 回文链表
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
 * 如果是，返回 true ；否则，返回 false 。
 *
 */
public class test {
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        //先通过快慢指针找到链表中点
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //如果fast不为null，代表链表节点个数为奇数
        if (fast != null) slow = slow.next;

        ListNode left = head;
        //反转slow后面的链表
        ListNode right = reverse(slow);
        while (right != null){
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    ListNode reverse(ListNode head){
        ListNode pre, cur, nxt;
        pre = null;
        cur = head;
        while (cur != null){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
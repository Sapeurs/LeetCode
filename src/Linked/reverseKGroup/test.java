package Linked.reverseKGroup;

/**
 * @author: Spaeurs
 * @date: 2021/8/31 20:15
 * @description: 25. K 个一组翻转链表
 *
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *
 */
public class test {
}


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        //区间[a,b)包含k个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            //不足k个，不需要反转
            if (b == null) return head;
            b = b.next;
        }
        //反转前k个元素
        ListNode newNode = reverse(a,b);
        //递归反转后续链表，并连接起来
        a.next = reverseKGroup(b,k);
        return newNode;
    }

    /**
     *反转区间[a,b)的元素
     */
     ListNode reverse(ListNode a, ListNode b){
         ListNode pre, cur, nxt;
         pre = null;
         cur = a;
         while (cur != b){
             nxt = cur.next;
             cur.next = pre;
             pre = cur;
             cur = nxt;
         }
         //返回反转后的头结点
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
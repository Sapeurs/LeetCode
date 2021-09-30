package Linked.mergeKLists;

/**
 * @author: Spaeurs
 * @date: 2021/9/24 21:37
 * @description: 23. 合并K个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 */
public class test {

}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode res = null;
        for (ListNode list : lists) {
            res = mergeTwoLists(res, list);
        }
        return res;
    }

    public ListNode mergeTwoLists(ListNode node1, ListNode node2){
//        if (l1 == null || l2 == null){
//            return l1 != null ? l1 : l2;
//        }
        ListNode dummy = new ListNode(-1), cur = dummy, l1 = node1, l2 = node2;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            }else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
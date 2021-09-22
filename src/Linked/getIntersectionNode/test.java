package Linked.getIntersectionNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Sapeurs
 * @date: 2021/5/31 22:08
 * @description: 剑指 Offer 52. 两个链表的第一个公共节点
 * <p>
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class test {
}


class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }

    //hash表
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if (set.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
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

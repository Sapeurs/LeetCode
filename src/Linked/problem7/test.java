package Linked.problem7;

/**
 * @author: Sapeurs
 * @date: 2021/6/22 20:48
 * @description: 剑指offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
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
        node1[0].val = 1;
        node1[1].val = 2;
        node1[2].val = 4;
        node2[0].val = 1;
        node2[1].val = 3;
        node2[2].val = 4;

        Solution solution = new Solution();
        ListNode listNode = solution.mergeTwoLists(node1[0], node2[0]);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(1);
        ListNode pre = node;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val >= l2.val) {
                    pre.next = l2;
                    l2 = l2.next;
                } else {
                    pre.next = l1;
                    l1 = l1.next;
                }
            } else if (l1 == null) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        return node.next;
    }

    //K解法
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        //当l1或l2为null时，直接将不为null的链表赋给cur.next
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode() {
    }
}

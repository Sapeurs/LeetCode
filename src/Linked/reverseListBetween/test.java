package Linked.reverseListBetween;

/**
 * @author: Spaeurs
 * @date: 2021/8/30 21:40
 * @description: 92. 反转链表 II
 *
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 */
public class test {

}

class Solution {

    //递归解法
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1){
            //相当于反转前right个元素
            return reverseN(head,right);
        }
        //前进到left=1的时候触发base case
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    ListNode successor = null;//记录后驱节点
    //反转前n个节点
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1){
            //记录第n+1个节点
            successor = head.next;
            return head;
        }

        //以head.next为起点，反转前n-1个节点
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        //让反转后的head节点和后面的节点连起来
        head.next = successor;
        return last;
    }


    //迭代解法
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
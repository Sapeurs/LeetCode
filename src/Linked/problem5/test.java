package Linked.problem5;

/**
 * @author: Sapeurs
 * @date: 2021/4/13 22:16
 * @description: 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
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
        ListNode listNode = solution.removeNthFromEnd(node[0], 5);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}


class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode former = head, latter = head;
        for (int i = 0; i < n; i++) {
            former = former.next;
        }
        if (former == null)
            return head.next;
        former = former.next;
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        latter.next = latter.next.next;
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




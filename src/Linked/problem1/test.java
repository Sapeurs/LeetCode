package Linked.problem1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Sapeurs
 * @date: 2021/4/12 21:49
 * @description: 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class test {
}

class Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head.next != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = list.get(size - i - 1);
        }
        return ans;
    }
}


//使用递归
class Solution1 {

    int[] res;
    int i = 0;
    int j = 0;

    public int[] reversePrint(ListNode head) {
        solve(head);
        return res;
    }

    public void solve(ListNode head) {
        if (head == null) {
            res = new int[i];
            return;
        }
        i++;
        solve(head.next);
        res[j] = head.val;
        j++;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

package Linked.problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author: Sapeurs
 * @date: 2021/4/12 21:49
 * @description: 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class test {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        Solution1 solution = new Solution1();
        System.out.println(Arrays.toString(solution.reversePrint(node1)));
    }
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

    //用栈实现
    public int[] reversePrint1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

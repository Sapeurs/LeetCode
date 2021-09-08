package Test.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Spaeurs
 * @date: 2021/9/5 21:02
 * @description:
 */
public class test1 {
    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
   ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a ListNode类一维数组 指向这些数链的开头
     * @return ListNode类
     */
    public ListNode solve (ListNode[] a) {
        // write code here
        List<ListNode> list = new ArrayList<>();
        for (ListNode listNode : a) {
            if (listNode != null)
                list.add(listNode);
        }

        ListNode node = new ListNode(0);
        node.next = null;
        ListNode tmp = node;
        while (list.size() != 0){
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null){
                    node.next = list.get(i);
                    node = node.next;
                    list.set(i,list.get(i).next);
                }else {
                    list.remove(i);
                    i--;
                }
            }
        }
        return tmp.next;
    }
}
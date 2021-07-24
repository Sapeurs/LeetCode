package Test;


import org.junit.Test;

import java.util.*;

/**
 * @author: Sapeurs
 * @date: 2021/4/14 8:47
 * @description:
 */
public class test {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()) {
            String[] str = cin.nextLine().split(" ");
            int sum = 0;
            for (String s : str) {
                sum += Integer.parseInt(s);
            }
            System.out.println(sum);
        }
    }

    public List<Integer> solutionByHeap(int[] input, int k) {
        List<Integer> list = new ArrayList<>();
        if (k > input.length || k == 0) {
            return list;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : input) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (queue.peek() < num) {
                queue.poll();
                queue.add(num);
            }
        }
        while (k-- > 0) {
            list.add(queue.poll());
        }
        return list;
    }

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            String item = iterator.next();
//            if ("1".equals(item))
//                iterator.remove();
//        }

        //这种方式删除会报错
        for (String item :
                list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }
        System.out.println(list.toString());
    }

    @Test
    public void test2() {
        String[] strings = {"a", "b", "c"};
        List<String> list1 = Arrays.asList(strings);
        List<String> list = new ArrayList<>(Arrays.asList(strings));
        System.out.println(list.toString());
        System.out.println(list1.toString());
    }

    @Test
    public void test3() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()) {
            String[] str = cin.nextLine().split(" ");
            int sum = 0;
            for (String s : str) {
                sum += Integer.parseInt(s);
            }
            System.out.println(sum);
        }
    }

    @Test
    public void test4() {
        ListNode[] node = new ListNode[5];
        for (int i = 0; i < 5; i++) {
            node[i] = new ListNode(i + 1);
        }
        for (int i = 1; i < 5; i++) {
            node[i - 1].next = node[i];
        }
        Solution solution = new Solution();
        ListNode node1 = solution.solve(node[0]);
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }


    }

    @Test
    public void test5() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        List<Integer> timeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            timeList.add(i, sc.nextInt());
            sc.nextLine();
        }

        int[][] arr = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                arr[i][j] = timeList.get(i) * (j + 1);
            }
        }
        int min = 1001;
        int i, j, row = 0, col = 0;
        while (k > 0) {
            for (i = 0; i < arr.length; i++) {
                for (j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] < min) {
                        min = arr[i][j];
                        row = i;
                        col = j;
                    }
                }
            }
            System.out.println(row + 1);
            arr[row][col] = 1001;
            min = 1001;
            k--;
        }
    }

    @Test
    public void test6() {

    }

}


class Solution {
    public ListNode solve(ListNode S) {

        Queue<Integer> queue = new LinkedList<>();
        while (S != null) {
            queue.offer(S.val);
            S = S.next;
        }
        int len = queue.size();
        int[] ans = new int[len * len];
        for (int i = 0; i < len; i++) {
            queue.offer(queue.poll());
            for (int j = i * len; j < (i + 1) * len; j++) {
                ans[j] = queue.peek();
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len * len; j += len) {

            }
        }
        return null;
    }

    public boolean isEqual(String s1, String s2) {
        if (s1.length() % 2 == 1) {
            isEqualOdd(s1, s2);
        } else {
            String subS11 = s1.substring(0, s1.length() / 2);
            String subS12 = s1.substring(s1.length() / 2);
            String subS21 = s2.substring(0, s1.length() / 2);
            String subS22 = s2.substring(s1.length() / 2, s1.length());
            return (isEqual(subS11, subS21) && isEqual(subS12, subS22) || isEqual(subS11, subS22) && isEqual(subS12, subS21));
        }
        return false;
    }

    public boolean isEqualOdd(String s1, String s2) {
        return s1.equals(s2);
    }

//    int[] queueToInt(Queue<Integer> queue){
//        int len = queue.size();
//        int[] ans = new int[len];
//        for (int i = 0; i < len; i++) {
//            ans[i] = queue.poll();
//        }
//        return ans;
//    }
//
//    public ListNode reverseNode(ListNode head){
//        ListNode pre = head, cur = head;
//        pre = pre.next;
//        while (pre.next != null){
//            pre = pre.next;
//            cur = cur.next;
//        }
//        pre.next = head;
//        cur.next = null;
//        return pre;
//    }
}


class ListNode {
    int val;
    ListNode next = null;

    public ListNode() {
    }

    public ListNode(int i) {
        val = i;
    }
}
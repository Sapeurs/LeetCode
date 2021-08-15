package HashMap.isHappy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为 1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 */

public class test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean happy = solution.isHappy(7);
        System.out.println(happy);
    }
}


class Solution {
    List list = new ArrayList();

    public boolean isHappy(int n) {
        addToList(n);
        int i = 0;
        int sum = toSum(list);
        while (sum != 1) {
            list.clear();
            addToList(sum);
            sum = toSum(list);
            i++;
            if (i > 10000)
                return false;
        }
        return true;
    }

    public int addToList(int n) {
        list.add(n % 10);
        if (n >= 10) {
            return addToList(n / 10);
        }
        return n;
    }

    public int toSum(List list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            Math.pow((int) list.get(i), 2);
            sum += (int) list.get(i);
        }
        return sum;
    }
}


///官方解法
class Solution1 {

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }


}

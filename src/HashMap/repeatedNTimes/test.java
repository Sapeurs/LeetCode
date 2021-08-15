package HashMap.repeatedNTimes;

import java.util.HashSet;
import java.util.Set;


/**
 * 961. 重复 N 次的元素
 *
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 *
 * 返回重复了 N 次的那个元素。
 *
 */

public class test {
    public static void main(String[] args) {
    }
}


class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> setA = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            setA.add(A[i]);
        }

        for (Integer a : setA
        ) {
            int sum = 0;
            for (int j : A) {
                if (a == j) {
                    sum++;
                    if (sum == A.length / 2)
                        return a;
                }
            }
        }
        return 0;
    }
}
package HashMap.problem12;

import java.util.HashSet;
import java.util.Set;

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
            for (int i = 0; i < A.length; i++) {
                if (a == A[i]) {
                    sum++;
                    if (sum == A.length / 2)
                        return a;
                }
            }
        }
        return 0;
    }
}
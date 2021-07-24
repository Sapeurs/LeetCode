package Other.problem1;

import org.junit.Test;

public class test {

    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    @Test
    public void test1() {
        int n = 9;
        System.out.println(sumNums(n));
    }
}


class Solution {
    public int sumNums(int n) {
        if (n == 1) return 1;
        return n + sumNums(n - 1);
    }
}
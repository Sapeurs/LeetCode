package Array.problem3;

import org.junit.Test;

/**
 * @author: Sapeurs
 * @date: 2021/3/26 21:43
 * @description: 打印出1-10^n的数字
 */
public class test {
    public static void main(String[] args) {

    }

    //普通做法（返回值为int）
    public int[] printNumbers(int n) {
        int m = (int) Math.pow(10, n);
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        System.out.println(solution.printNumbers(2));

    }
}

//大数全排列解法（返回值为String）
class Solution {
    StringBuilder res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public String printNumbers(int n) {
        this.n = n;
        res = new StringBuilder();
        num = new char[n];
        start = n - 1;
        dfs(0);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) res.append(s + ",");
            if (n - start == nine) start--;
            return;
        }
        for (char i : loop) {
            if (i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
}
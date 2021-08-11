package Dp.nthUglyNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Sapeurs
 * @date: 2021/7/12 19:13
 * @description: 剑指 Offer 49. 丑数
 * <p>
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 求按从小到大的顺序的第 n 个丑数。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(230));
    }
}


class Solution {
    //超时
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        for (int i = 6, j = 6; i <= n; j++) { //i表示第几个丑数
            if ((map.containsValue(j / 2) && j % 2 == 0)
                    || (map.containsValue(j / 3) && j % 3 == 0)
                    || (map.containsValue(j / 5) && j % 5 == 0)) {
                map.put(i, j);
                i++;
            }
        }
        return map.get(n);
    }


    public int nthUglyNumber1(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }

    public int nthUglyNumber2(int n){
        int[] dp = new int[n];
        dp[0] = 1;
        int a=0, b= 0,c = 0;
        for (int i = 1; i < n; i++) {
            int min1 = dp[a] * 2;
            int min2 = 3 * dp[b];
            int min3 = 5 * dp[c];
            dp[i] = Math.min(Math.min(min1,min2),min3);
            if (dp[i] == min1) a++;
            if (dp[i] == min2) b++;
            if (dp[i] == min3) c++;
        }
        return dp[n-1];
    }
}
package Test.eBay;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: Spaeurs
 * @date: 2021/9/29 20:06
 * @description:
 */
public class test2 {

    static long mod = (long) Math.pow(2,55) + 1;
    static int n = 62;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        longestString(str);
    }

    static void longestString(String str){
        int left = 1;
        int right = str.length() - 1;
        int ans = 0;
        while (left <= right){
            int mid = left + (right - left)/2;
            int tmp = helper(str, mid);
            if (tmp == -1){
                right = mid - 1;
            }else {
                ans = mid;
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static int helper(String str, int m){
        long high = 0;
        long l = 1;
        char[] chars = str.toCharArray();
        for (int i = 0; i < m; i++) {
            high = (high * n + (chars[i] - 'a')) % mod;
            l = (l * n) % mod;
        }
        Set<Long> set = new HashSet<>();
        set.add(high);
        for (int i = 1; i < chars.length - m + 1; i++) {
            high = (high * n - (chars[i-1] - 'a')* l % mod + mod) % mod;
            high = (high + (chars[i - 1 + m]- 'a')) % mod;
            if (set.contains(high)){
                return i;
            }
        }
        return -1;
    }
}
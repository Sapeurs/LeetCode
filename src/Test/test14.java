package Test;

import java.util.Arrays;

/**
 * @author: Spaeurs
 * @date: 2021/8/21 9:59
 * @description: 有赞
 */
public class test14 {
    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        System.out.println(solution12.isMatch("aa", "a"));
    }
}

class Solution11 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return bool布尔型
     */
    public boolean isMonotonic(int[] nums) {
        // write code here
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1])
                return false;
        }
        return true;
    }
}


class Solution12 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串 string
     * @param p string字符串 pattern
     * @return bool布尔型
     */
    public boolean isMatch(String s, String p) {
        // write code here

        /*
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        for (int j = 0; j <= p.length(); j++) {
            dp[0][j] = j == 0 || (j > 1 && dp[0][j - 2] && p.charAt(j - 1) == '*');
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j <= p.length() + 1; j++) {
                if (p.charAt(j - 1) != '*')
                    dp[i][j] = match(s.charAt(i - 1), p.charAt(j - 1)) && dp[i - 1][j - 1];
                else
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && match(p.charAt(j - 2), s.charAt(i - 1)));
            }
        }
        return dp[s.length()][p.length()];
        */
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if ('*' == p.charAt(j - 1)){
                    dp[i][j] = dp[i][j-2];
                    if (equal(s,p,i,j-1)){
                        dp[i][j] = dp[i][j] ||dp[i-1][j];
                    }
                }else {
                    if (equal(s, p, i, j))
                        dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    boolean match(char a, char b) {
        return a == b || a == '.' || b == '.';
    }

    boolean equal(String s, String p, int a, int b){
        if (a == 0)
            return false;
        if (p.charAt(b - 1) =='.')
            return true;
        return s.charAt(a - 1) == p.charAt(b - 1);
    }
}
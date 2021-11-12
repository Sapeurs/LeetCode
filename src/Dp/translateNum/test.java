package Dp.translateNum;

/**
 * @author: Spaeurs
 * @date: 2021/11/9 19:20
 * @description: 剑指 Offer 46. 把数字翻译成字符串
 *
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，
 * 1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字
 * 可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.translateNum(12258));
    }
}


class Solution {
    public int translateNum(int num) {
        char[] array = String.valueOf(num).toCharArray();
        int[] dp = new int[array.length];
        dp[0] = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i-1] == '1' || (array[i-1] == '2' && array[i] <= '5' && array[i] >= '0')){
                if (i == 1){
                    dp[i] = dp[i-1] + 1;
                }else {
                    dp[i] = dp[i-1] + dp[i-2];
                }
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[array.length-1];
    }
}
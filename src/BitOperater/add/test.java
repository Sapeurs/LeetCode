package BitOperater.add;

/**
 * @author: Spaeurs
 * @date: 2021/11/20 20:16
 * @description: 剑指 Offer 65. 不用加减乘除做加法
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 */
public class test {

}



class Solution {
    public int add(int a, int b) {
        while (b!=0){
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
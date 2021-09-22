package Test.zoom;

/**
 * @author: Spaeurs
 * @date: 2021/9/16 17:50
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(3));
    }
}

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param num int整型
     * @return string字符串
     */

    int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] chars = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman (int num) {
        // write code here
        int len = nums.length;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int tmp = nums[i];
            String s = chars[i];
            while (num>=tmp){
                num-=tmp;
                str.append(s);
            }
            if (num == 0) break;
        }
        return str.toString();
    }
}
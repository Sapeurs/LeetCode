package Test.xiecheng;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/16 19:28
 * @description:
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(" ");
        int[] nums= new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }


    }

    static int[] check(int num1, int num2){
        int[] ans = new int[10];
        return ans;
    }
}
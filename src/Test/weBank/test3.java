package Test.weBank;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/10 21:00
 * @description:
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] ans = new int[n];
        int a = nums[0],b = 0;
        ans[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if ((i+1)%2 == 0){
                ans[i] = a - b - nums[i];
                b+=ans[i];
            }else {
                ans[i] = b - a + nums[i];
                a += ans[i];
            }
        }
        for (int i = 0; i < n; i++) System.out.println(ans[i] + " ");
    }
}
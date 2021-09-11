package string.xiecheng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/9 19:29
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] ints = new int[n-1];
        for (int i = 0; i < n - 1; i++) {
            ints[i] = Math.abs(nums[i] - nums[i+1]);
        }
        Arrays.sort(ints);
        if (ints.length - k == 0)
            System.out.println(0);
        else
            System.out.println(ints[ints.length-k]);
    }
}
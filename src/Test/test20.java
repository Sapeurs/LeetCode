package Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/8/21 19:44
 * @description: 京东
 */
public class test20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i][0] - nums[j][0]) == Math.abs(nums[i][1] - nums[j][1]))
                    res++;
            }
        }
        System.out.println(res);
    }
}
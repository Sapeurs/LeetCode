package Test.baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/7 19:30
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long[] nums = new long[T];
        for (int i = 0; i < T; i++) {
            nums[i] = sc.nextLong();
        }

        System.out.println(Arrays.toString(nums));
    }
}
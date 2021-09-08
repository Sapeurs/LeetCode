package Test.beike;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/3 17:52
 * @description:
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] nums = new int[T];
        for (int i = 0; i < T; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < T; i++) {
            System.out.println(maxCount(nums[i]));
        }

    }

    static int maxCount(int n){
        if (n == 1)
            return 1;
        if (n % 2 == 0) return n/2;
        else return n/2+1;

    }
}
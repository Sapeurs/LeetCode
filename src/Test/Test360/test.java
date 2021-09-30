package Test.Test360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/25 16:38
 * @description:
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int res = 0;
        while (!check(nums)) {
            for (int i = 1; i < n-1; i++) {
                while (nums[i] >= nums[i-1] && nums[i] >= nums[i+1]){
                    nums[i]--;
                    res++;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(res);
    }

    static boolean check(int[] nums){
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i-1] && nums[i] >= nums[i+1]){
                return false;
            }
        }
        return true;
    }
}
package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/8/21 14:40
 * @description: 网易
 */
public class test15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int M = sc.nextInt();
        int[] nums = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            nums[i] = Integer.parseInt(s1[i]);
        }
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > M)
                    break;
                if (nums[i] + nums[j] <= M)
                    ans++;
            }
        }
        System.out.println(ans);
    }
}
package Test.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/15 19:02
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        int n = strs.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        String str1 = sc.nextLine();
        String[] strs1 = str1.split(" ");
        int m = strs1.length;
        int[] mec = new int[m];
        for (int i = 0; i < m; i++) {
            mec[i] = Integer.parseInt(strs1[i]);
        }

        System.out.println(check(nums,mec));

    }

    static int check(int[] nums, int[] mec){
        Arrays.sort(nums);
        Arrays.sort(mec);
        int radius = 0;
        int i = 0;
        for (int num :nums) {
            while (i < mec.length && mec[i] < num) {
                i++;
            }
            if (i==0)
                radius = Math.max(radius,mec[i] - num);
            else if (i == mec.length)
                return Math.max(radius,nums[nums.length - 1] - mec[mec.length - 1]);
            else
                radius = Math.max(radius,Math.min(mec[i] - num, num - mec[i-1]));
            }
        return radius;
    }
}
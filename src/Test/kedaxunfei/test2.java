package Test.kedaxunfei;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/8/28 20:03
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int[] nums = new int[n];
        String[] strings = s.split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
//        int max = 0;
//        int m = 1;
//        for (int i = 0; i < n-1; i++) {
//            if (nums[i] == nums[i+1])
//                m++;
//            else if (i + 2 < n && nums[i] == nums[i+2]){
//                m++;
//                max = Math.max(max,m);
//                m = 1;
//            }else {
//                max = Math.max(max,m);
//                m = 1;
//                if (i-1>0 && i+1<n && nums[i+1] == nums[i-1])
//                    m++;
//            }
//        }
//        max = Math.max(max,m);
//        System.out.println(max);
        System.out.println(len(nums));
    }

    static int len(int[] nums){
        int[] ans = new int[nums.length];
        int max = 1;
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1])
                ans[i] = ans[i-1] + 1;
            else ans[i] = 1;
            max = Math.max(max,ans[i]);
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i-1] == nums[i+1])
                ans[i-1]++;
            max = Math.max(max,ans[i-1]);
        }
        return max;
    }
}
package Test.Test360;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/25 17:13
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        sc.nextLine();
        int i = 0;
        while (i < n) {
            nums[i] = sc.nextInt();
            i++;
        }
        int m = 0;
        for (int j = 0; j < n; j++) {
            int tmp = 1;
            if (j == 0){
                int k = j+1;
                while (k<n&&nums[k] < nums[k-1]){
                    tmp++;
                    k++;
                }
                m = Math.max(m,tmp);
            }else if (j == n - 1){
                int k = j - 1;
                while (k >= 0 && nums[k+1]>nums[k]){
                    tmp++;
                    k--;
                }
                m = Math.max(m,tmp);
            }else {
                int left = j - 1;
                int right = j + 1;
                while (left >= 0 && nums[left + 1] > nums[left]){
                    tmp++;
                    left--;
                }
                while (right < n && nums[right] < nums[right - 1]){
                    tmp++;
                    right++;
                }
                m = Math.max(m,tmp);
            }
        }
        System.out.println(m);
    }
}
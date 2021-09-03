package Test.beike;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/3 18:25
 * @description:
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int index = 0;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= m){
                index = i;
                break;
            }
        }
        int ans = 0;
        n--;
        ans += nums[n];
        int l = n;
        while (n > 0){
            for (int i = index - 1; i > index - k; i--) {
                if (i>=0) tmp+=nums[i];
            }
            if (nums[l-1]>tmp&&nums[l-1]>m){
                ans+=nums[l-1];
                n=n-k-1;
                l--;
            }else if (n>=k){
                ans+=tmp;
                n=n-k;
                index = index-k;
            }else {
                ans+=nums[index];
                n--;
                index--;
            }
            tmp = 0;
        }
        System.out.println(ans);
    }
}
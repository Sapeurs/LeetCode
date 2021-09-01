package Test.xiaomi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Sapeurs
 * @date: 2021/9/1 19:41
 * @description:
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int index1 = s.indexOf('=');
        int index2 = s.indexOf(',');
        int index3 = s.lastIndexOf('=');
        int m = Integer.parseInt(s.substring(index1+1,index2));
        int n = Integer.parseInt(s.substring(index3+1));
        int[] nums1 = new int[m+n];
        int[] nums2 = new int[n];
        System.out.println(m + " " + n);
        String[] strings1 = s1.split(",");
        String[] strings2 = s2.split(",");
        for (int i = 0; i < m; i++) {
            nums1[i] = Integer.parseInt(strings1[i]);
        }
        for (int i = 0; i < n; i++) {
            nums2[i] = Integer.parseInt(strings2[i]);
        }

        int x = m - 1, y = n - 1, right = m + n - 1, index;
        while (x>=0 || y >=0){
            if (x == -1){
                index = nums2[y];
                y--;
            }else if (y == -1){
                index = nums1[x];
                x--;
            }else if (nums1[x]>nums2[y]){
                index = nums1[x];
                x--;
            }else {
                index = nums2[y];
                y--;
            }
            nums1[right] = index;
            right--;
        }
        Arrays.stream(nums1, 0, m + n).forEach(System.out::print);
    }
}

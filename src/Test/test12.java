package Test;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/8/1 16:26
 * @description:
 */
public class test12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(",");
        int len = str.length;
        String[] str1 = str[len - 1].split(":");
        int k = Integer.parseInt(str1[str1.length - 1]);
        str[len - 1] = str1[0];
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        double sum = sum(arr, k);
        DecimalFormat decimalFormat = new DecimalFormat("0.00%");
        String format = decimalFormat.format(sum);
        System.out.println(format);

    }

    private static double sum(int[] arr, int k){
        int len = arr.length;
        if (k == 0 || len == 0)
            return 0;
        double max = 0;
        double ans = 0;
        for (int i = 0; i < k; i++) {
            ans += arr[i];
        }
        for (int i = k; i < len - 1; i++) {
            double tmp = ans - arr[i - k] + arr[i];
            double ave = (tmp / ans) - 1;
            ans = tmp;
            max = Math.max(max,ave);
        }
        return max;
    }
}
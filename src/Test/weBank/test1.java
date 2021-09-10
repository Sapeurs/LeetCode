package Test.weBank;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/10 20:26
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        long[] nums = new long[T];
        for (int i = 0; i < T; i++) {
            nums[i] = sc.nextLong();
        }
        for (int i = 0; i < T; i++) {
            if (isExist(nums[i]))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    static boolean isExist(long n) {
        long z = (long) Math.pow(n, (double) 1 / 5);
        long y = (long) Math.pow(n - Math.pow(z, 5), (double) 1 / 4);
        double x = Math.pow(n - Math.pow(z, 5) - Math.pow(y, 4), (double) 1 / 3);
        long x1 = (long) x;
        return x % x1 == 0;
    }

    static boolean isExist1(long n){
        for (long i = 1; i <= Math.sqrt(n); i++) {
            for (long j = 1; j <= Math.sqrt(Math.sqrt(n)); j++) {
                long start = (long) (n - Math.pow(i,3) - Math.pow(i,5));
                if (start!=0 && Math.sqrt(Math.sqrt(start)) %1 == 0)
                    return true;
            }
        }
        return false;
    }
}
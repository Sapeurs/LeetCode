package Test.eBay;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/29 19:52
 * @description:
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int ans = 0;
        for (int i = m; i <= n; i++) {
            if (check(i)){
                ans++;
            }
        }
        System.out.println(ans);
    }

    static boolean check(int n){
        String str = String.valueOf(n);
        return str.contains("6") || str.contains("17");
    }
}
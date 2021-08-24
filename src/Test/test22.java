package Test;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/8/21 20:49
 * @description:
 */
public class test22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int n1 = 0,n0 = 0;
            for (int i = 1; i <= s.length(); i++) {
                String substring = s.substring(0, i);
                if (s.charAt(i-1) == '0')
                    n0++;
                else n1++;
                System.out.print(max(n0,n1,substring) + " ");
            }

    }

    static int max(int a, int b, String s){
        if (s.length() == 0) return 0;
        int n0 = 0, n1 = 0;
        int M = 1;
        if (a ==0 || b == 0) return s.length();
        else {
            int m;
            for (int i = 0; i < s.length(); i++) {
                m = 0;
                if (s.charAt(i) == '0')
                    n0++;
                else n1++;
                if (n0 * b == n1 * a)
                    m = Math.max(max(a - n0, b - n1, s.substring(n0 + n1)) + 1,m);
                M = Math.max(m,M);
            }
        }
        return M;
    }
}
package Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/8/21 20:08
 * @description: 京东
 */
public class test21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int a = 0, b = 0;
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0')
                a++;
            if (s.charAt(i) == '1')
                b++;
            if (i == 0){
                val[i] = 1;
            }else {
                if (a == 0) val[i] = b;
                if (b == 0 || b == a) {
                    val[i] = a;
                }else {
                    val[i] = maxCom(a,b);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(val[i]);
        }
    }

    static int maxCom(int n0, int n1){
        if (n0 < n1){
            int r = n0;
            n0 = n1;
            n1 = r;
        }
        if (n0 % n1 == 0) return n1;
        else return maxCom(n1, n0 % n1);
    }
}
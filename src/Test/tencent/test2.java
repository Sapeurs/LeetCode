package Test.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/5 20:37
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a[i] = yueshu(a[i]);
        }
        for (int i = 0; i < n; i++) {
            b[i] = yueshu(b[i]);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int count = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j<n){
                if (a[j]>b[i]){
                    count++;
                    j++;
                    break;
                }
                j++;
            }
        }
        System.out.println(count);
    }

    static int yueshu(int a){
        int num = 0;
        for (int i = 1; i <= Math.sqrt(a); i++) {
            if (a%i==0){
                if (i!=Math.sqrt(a))
                    num+=2;
                else
                    num+=1;
            }
        }
        return num;
    }
}
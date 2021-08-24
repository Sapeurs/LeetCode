package Test.meituan;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/8/22 11:09
 * @description:
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        if (s.length() < 2) System.out.println(0);
        int ans = 1, sum = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                ans*=sum;
                sum = 1;
            }else {
                sum++;
            }
        }
        System.out.println(ans*sum);
    }


}
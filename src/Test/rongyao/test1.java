package Test.rongyao;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/18 18:28
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String command = sc.nextLine();
        String[] str1 = str.split(" ");
        String[] str2 = command.split(" ");
        int left = Integer.parseInt(str2[0]) - 1, length = Integer.parseInt(str2[1]), right;
        right = Math.min(left + length, str1.length);
        int n = 1;
        StringBuilder ans = new StringBuilder();
        int i = left;
        while (i < right) {
            ans.append(str1[i]).append(";");
            if (n % 20 == 0){
                System.out.println(ans.substring(0,ans.length()-1));
                ans = new StringBuilder();
            }
            n++;
            i++;
        }
        if (ans.length() > 0){
            System.out.println(ans.substring(0,ans.length()-1));
        }

    }
}
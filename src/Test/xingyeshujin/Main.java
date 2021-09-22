package Test.xingyeshujin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/22 19:22
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] res = str.split(" ");
        Arrays.sort(res);
        for (String re : res) {
            System.out.print(re + " ");
        }
    }
}
package Test.ali;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/8/27 19:09
 * @description:
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        String[] strings = s.split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        for (int i = 0; i < k; i++) {

        }
    }
}
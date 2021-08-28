package Test.kedaxunfei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/8/28 19:46
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int grade = sc.nextInt();
        int[] nums = new int[50];
        for (int i = 0; i < 50; i++) {
            nums[i] = Integer.parseInt(s.split(" ")[i]);
        }
        Arrays.sort(nums);
        if (grade >= nums[45])
            System.out.println("A+");
        else if (grade >= nums[35])
            System.out.println("A0");
        else if (grade >= nums[20])
            System.out.println("B+");
        else if (grade >= nums[15])
            System.out.println("B0");
        else if (grade >= nums[5])
            System.out.println("C+");
        else if (grade >= nums[2])
            System.out.println("C0");
        else
            System.out.println("F");

    }
}
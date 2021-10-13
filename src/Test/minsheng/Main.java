package Test.minsheng;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/10/9 19:28
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str.contains("red")){
            System.out.print(1 + " ");
        }else {
            System.out.print(0+ " ");
        }
        if (str.contains("yellow")){
            System.out.print(1+ " ");
        }else {
            System.out.print(0+ " ");
        }
        if (str.contains("blue")){
            System.out.print(1);
        }else {
            System.out.print(0);
        }
    }
}
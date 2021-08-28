package Test.kedaxunfei;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/8/28 20:17
 * @description:
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] ints = new int[T][2];
        for (int i = 0; i < T; i++) {
            ints[i][0] = sc.nextInt();
            ints[i][1] = sc.nextInt();
        }
        Double ans = 0.0;
        for (int i = 0; i < T; i++) {
            System.out.println(1-isFall(ints[i][0],ints[i][1]));
        }
    }

    static Double isFall(int x, int t){
        int right = 60 - x;
        int max = Math.max(x,right);
        int min = 60 - max;
        if (min > t)
            return 0.0;
        if (t < max)
            return Math.pow(0.5,t);
        return 2*Math.pow(0.5,t);
    }
}
package Test;

import java.util.Scanner;

/**
 * @author: Sapeurs
 * @date: 2021/4/28 20:10
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int ans = 0;
        for (int i = X; i <= Y; i++) {
            int len = 0;
            for (int j = i; j <= Y; j++) {
                if (j % i == 0) {
                    len++;
                    i = j;
                }

            }
            ans = Math.max(len, ans);
        }
        System.out.println(ans);
        P p = new C();
    }
}

class P{
    double a(){
        return 0;
    }
}

class C extends P{
    int A(){
        return 0;
    }

//    double a() {
//        return 0;
//    }

//    void a(){
//        return 0;
//    }
}
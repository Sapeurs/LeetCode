package Test.beike;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/3 18:53
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0){
            int n = sc.nextInt();
            sc.nextLine();
            String string = sc.nextLine();
            char[] chars = string.toCharArray();
            LinkedList<Character> list = new LinkedList<Character>();
            int res = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(')
                    list.push(chars[i]);
                if (chars[i] == ')'){
                    if (list.isEmpty())
                        res++;
                    else
                        list.pop();
                }
            }
            T--;
            System.out.println(res);
        }
    }
}
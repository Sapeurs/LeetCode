package Test.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/8/22 11:14
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        /*
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int opt = sc.nextInt();
            char c = sc.next().charAt(0);
            if (opt == 1){
                s = s + c;
            }else if(opt == 2){
                String str = String.valueOf(c);
                int pos = Integer.parseInt(str);
                int val = findDis(s, pos - 1);
                System.out.println(val);
            }
        }
        */
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        String s = sc.next();
        str.append(s);
        sc.nextLine();
        int n = sc.nextInt();
        String[][] opts = new String[n][2];
        for (int i = 0; i < n; i++) {
            int op = sc.nextInt();
            String content = sc.next();
            opts[i][0] = String.valueOf(op);
            opts[i][1] = content;
            sc.nextLine();
        }

        for (String[] opt : opts) {
            if (opt[0].equals("1")){
                str.append(opt[1]);
            }else {
                int i = Integer.parseInt(opt[1]);
                String curStr = str.toString();
                String target = curStr.substring(i, i + 1);
                //int left = curStr.lastIndexOf(target,0);
                int left = curStr.indexOf(target, 0);
                int right = curStr.lastIndexOf(target);
                if (left == -1 && right == -1) System.out.println(-1);
                else if (left == -1 || left == i) System.out.println(Math.abs(i - right));
                else if (right == -1 || right == i) System.out.println(Math.abs(i - left));
                else System.out.println(Math.min(Math.abs(i - right), Math.abs(i - left)));
            }
        }
    }

    static int findDis(String s, int pos){
        char c = s.charAt(pos);
        int p = pos - 1;
        int q = pos + 1;
        int left = -1, right = -1;
        while (p >= 0){
            if (s.charAt(p--) == c)
                left = p + 1;
        }
        while (q <= s.length() - 1){
            if (s.charAt(q++) == c)
                right = q - 1;
        }
        if (left == -1 && right == -1) return -1;
        else if (left == -1) return Math.abs(pos - right);
        else if (right == -1) return Math.abs(pos - left);
        return Math.min(Math.abs(pos - right), Math.abs(pos - left));
    }
}
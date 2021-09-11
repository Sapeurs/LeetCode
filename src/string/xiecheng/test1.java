package string.xiecheng;

import java.util.*;

/**
 * @author: Spaeurs
 * @date: 2021/9/9 19:03
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strings = new String[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            strings[i] = sc.nextLine();
        }
        Stack<String> stack = new Stack<>();
        for (String s :strings) {
            if (s.startsWith("cd")){
                if (s.substring(3).equals("..")){
                    if (stack.isEmpty()) continue;
                    stack.pop();
                }
                else
                    stack.push(s.substring(3));
            }else {
                if (stack.isEmpty())
                    System.out.println("\\");
                else {
                    Stack<String> tmp = new Stack<>();
                    while (!stack.isEmpty()){
                        tmp.push(stack.pop());
                    }
                    StringBuilder sb = new StringBuilder();
                    while (!tmp.isEmpty()){
                        sb.append("\\");
                        String s1 = tmp.pop();
                        sb.append(s1);
                        stack.push(s1);
                    }
                    System.out.println(sb);
                }
            }
        }
    }
}
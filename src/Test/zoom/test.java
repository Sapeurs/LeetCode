package Test.zoom;

import java.util.Stack;

/**
 * @author: Spaeurs
 * @date: 2021/9/16 17:42
 * @description:
 */
public class test {
    public static void main(String[] args) {
        System.out.println(check("<>{}"));
    }

    static boolean check(String str){
        if (str == null||str.length() == 0) return false;
        Stack<Character> stack = new Stack<>();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == '<' || str.charAt(i) == '('|| str.charAt(i) == '['|| str.charAt(i) == '{')
                stack.add(str.charAt(i));
            else if (str.charAt(i) == '>'){
                if (!stack.isEmpty() && stack.peek() == '<')
                    stack.pop();
                else return false;
            }else if (str.charAt(i) == '}'){
                if (!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else return false;
            }else if (str.charAt(i) == ')'){
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else return false;
            }else {
                if (!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
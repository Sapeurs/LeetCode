package Stack.isValid;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Spaeurs
 * @date: 2021/10/10 20:47
 * @description: 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 */
public class test {
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("{[]}"));
    }
}


class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c :s.toCharArray()) {
            if (!stack.isEmpty()){
                if (c == ')' && stack.peek() == '('){
                    stack.pop();
                }else if (c == ']' && stack.peek() == '['){
                    stack.pop();
                }else if (c == '}' && stack.peek() == '{'){
                    stack.pop();
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
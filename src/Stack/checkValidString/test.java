package Stack.checkValidString;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Spaeurs
 * @date: 2021/10/18 21:00
 * @description: 678. 有效的括号字符串
 *
 * 给定一个只包含三种字符的字符串：（，）和 *，写一个函数来检验这个字符串是否为有效字符串。
 * 有效字符串具有如下规则：
 *
 * 任何左括号 (必须有相应的右括号 )。
 * 任何右括号 )必须有相应的左括号 (。
 * 左括号 ( 必须在对应的右括号之前 )。
 * *可以被视为单个右括号 )，或单个左括号 (，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 *
 */
public class test {

}



class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '('){ //遇到左括号，将字符串当前下标存入左括号栈
                stack1.push(i);
            }else if (c == '*'){//遇到星号，将字符串当前下标存入星号栈
                stack2.push(i);
            }else {//遇到右括号，则需要有一个左括号或者一个星号与右括号匹配
                /*
                由于星号也可以看成右括号或者空字符串，因此当前的右括号应优先和左括号匹配
                没有左括号时和星号匹配
                 */
                if (!stack1.isEmpty()){
                    stack1.pop();
                }else if (!stack2.isEmpty()){
                    stack2.pop();
                }else {
                    return false;
                }
            }
        }
        /*
        如果栈中还有元素，分别弹出栈顶元素，如果左括号下标大于星号下标，说明匹配失败
        返回false
         */
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            int left = stack1.pop();
            int right = stack2.pop();
            if (left > right){
                return false;
            }
        }
        return stack1.isEmpty();
    }
}
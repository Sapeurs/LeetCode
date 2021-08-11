package Stack.minStack;

import java.util.Stack;

/**
 * @author: Sapeurs
 * @date: 2021/7/3 21:09
 * @description: 剑指 Offer 30. 包含min函数的栈
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素
 * 的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class test {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }
}


class MinStack {

    Stack<Integer> stack1, stack2;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int x) {
        stack1.add(x);
        if (stack2.empty() || stack2.peek() >= x)
            stack2.add(x);
    }

    public void pop() {
        if (stack1.pop().equals(stack2.peek()))
            stack2.pop();

    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
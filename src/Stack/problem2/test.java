package Stack.problem2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: Sapeurs
 * @date: 2021/3/31 9:35
 * @description: 请根据每日气温列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，
 * 至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替
 */
public class test {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums2 = {2, 6, 4, 8, 3, 1};
        int[] result = solution.dailyTemperatures(nums2);
        System.out.println(Arrays.toString(result));
    }
}


class Solution {
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = T.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int tem = T[i];
            //将索引进栈
            while (!stack.isEmpty() && tem > T[stack.peek()]) {//获取栈顶元素
                int prevIndex = stack.pop();//移除栈顶元素并返回
                result[prevIndex] = i - prevIndex;//将等待天数放入结果数组
            }
            stack.push(i);//在栈顶添加元素
        }
        return result;
    }
}
package Stack.calPoints;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Sapeurs
 * @date: 2021/4/2 9:05
 * @description: 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分
 * 可能会影响以后几回合的得分。
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i]
 * 是你需要记录的第 i 项操作，ops 遵循下述规则：
 * <p>
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 */
public class test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] ops = {"1", "C", "-62", "-45", "-68"};
        System.out.println(solution.calPoints(ops));
    }

    @Test
    public void test1() {
        char a = '5';
        char b = '9';
        String c = "-24";
        System.out.println(Integer.parseInt(c));
    }

}


class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        int a, b, sum = 0;
        for (String s : ops
        ) {
            if (s.charAt(0) == 67) {
                stack.pop();
            } else if (s.charAt(0) == 68) {
                stack.push(stack.peek() * 2);
            } else if (s.charAt(0) == 43) {
                a = stack.pop();
                b = stack.pop();
                stack.push(b);
                stack.push(a);
                stack.push(a + b);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        for (int i :
                stack) {
            sum += i;
        }

        return sum;
    }
}
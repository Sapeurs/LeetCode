package Search.openLock;

import java.util.*;

/**
 * @author: Spaeurs
 * @date: 2021/8/10 19:50
 * @description: 752. 打开转盘锁
 * <p>
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4',
 * '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为'0'，'0' 变为 '9'。
 * 每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将
 * 会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解
 * 锁，返回 -1 。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.openLock(new String[]{"8888"}, "0009"));
    }
}


class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        //需要跳过的死亡密码
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        //记录已经穷举过的密码
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            //将当前队列中的所有节点向周围扩散
            for (int i = 0; i < len; i++) {
                String cur = queue.poll();
                //判断是否到达终点
                if (deads.contains(cur))
                    continue;
                if (Objects.equals(cur, target))
                    return step;
                //将当前节点的所有相邻节点加入队列
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    //将s[j]向上拨动一次
    String plusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '9')
            chars[j] = '0';
        else
            chars[j] += 1;
        return new String(chars);
    }

    //将s[j]向下拨动一次
    String minusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '0')
            chars[j] = '9';
        else
            chars[j] -= 1;
        return new String(chars);
    }
}
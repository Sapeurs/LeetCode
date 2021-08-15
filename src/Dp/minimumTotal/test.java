package Dp.minimumTotal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Sapeurs
 * @date: 2021/5/5 14:07
 * @description: 120.三角形最小路径和
 * <p>
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标
 * 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，
 * 那么下一步可以移动到下一行的下标 i 或 i + 1 。
 */
public class test {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<Integer>() {{
            add(2);
        }};
        List<Integer> list2 = new ArrayList<Integer>() {{
            add(3);
            add(4);
        }};
        List<Integer> list3 = new ArrayList<Integer>() {{
            add(6);
            add(5);
            add(6);
        }};
        List<Integer> list4 = new ArrayList<Integer>() {{
            add(4);
            add(1);
            add(8);
            add(3);
        }};
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        Solution solution = new Solution();
        System.out.println(solution.minimumTotal1(triangle));
    }
}


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len];
        int[] temp;
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i++) {
            temp = dp.clone();
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[j] = triangle.get(i).get(j) + temp[0];
                } else if (i == j) {
                    dp[j] = triangle.get(i).get(j) + temp[i - 1];
                } else {
                    dp[j] = Math.min(temp[j], temp[j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        Arrays.sort(dp);
        return dp[0];
    }

    public int minimumTotal1(List<List<Integer>> triangle){
        int len = triangle.size();
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                int num = triangle.get(i).get(j);
                if (j == i)
                    triangle.get(i).set(j,num + triangle.get(i-1).get(j-1));
                else if (j == 0)
                    triangle.get(i).set(j,num + triangle.get(i-1).get(j));
                else
                triangle.get(i).set(j,Math.min(triangle.get(i-1).get(j),triangle.get(i-1).get(j-1)) + num);
            }
        }
        triangle.get(len-1).sort(null);
        return triangle.get(len-1).get(0);
    }
}
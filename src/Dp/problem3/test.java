package Dp.problem3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Sapeurs
 * @date: 2021/4/22 21:50
 * @description: 118.杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> generate = solution.generate(5);
        System.out.println(generate.toString());

    }
}


class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0)
            return null;
        int[][] dp = new int[numRows][numRows];
        List<List<Integer>> list = new ArrayList<>();
        dp[0][0] = 1;
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        list.add(arrayList);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list1 = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                list1.add(dp[i][j]);
            }
            list.add(list1);
        }
        return list;
    }


    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }

}


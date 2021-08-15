package Dp.maxScoreSightseeingPair;

/**
 * @author: Sapeurs
 * @date: 2021/7/22 19:57
 * @description: 1014. 最佳观光组合
 * <p>
 * 给你一个正整数数组 values，其中 values[i]表示第 i 个观光景点的评分，
 * 并且两个景点i和j之间的距离为j - i。
 * <p>
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，
 * 也就是景点的评分之和 减去 它们两者之间的距离。
 * <p>
 * 返回一对观光景点能取得的最高分。
 */
public class test {
}


class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length;
        int max = values[0];
        int res = 0;
        for (int i = 1; i < len; i++) {
            res = Math.max(res, max + values[i] - i);
            max = Math.max(values[i] + i, max);
        }
        return res;
    }
}
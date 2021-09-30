package Dp.maxEnvelopes;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: Spaeurs
 * @date: 2021/9/27 21:45
 * @description: 354. 俄罗斯套娃信封问题
 *
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 *
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 注意：不允许旋转信封。
 *
 */
public class test {
    public static void main(String[] args) {
        //System.out.println(new Solution().maxEnvelopes(new int[][]{{5, 4},{5,2}, {6, 4}, {6, 7}, {2, 3},{1,8}}));
        System.out.println(new Solution().maxEnvelopes(new int[][]{{5, 4}}));
    }
}



class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0]){
                return o1[0] - o2[0];
            }else {
                return o2[1] - o1[1];
            }
        });
        int[] dp = new int[envelopes.length];
        int res = 1;
        Arrays.fill(dp,1);
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
package Array.problem4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: Sapeurs
 * @date: 2021/5/9 21:16
 * @description: 剑指offer 57. 和为s的连续正数序列
 * <p>
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.findContinuousSequence1(9)));
    }
}


class Solution {
    //求和公式法
    public int[][] findContinuousSequence(int target) {
        int i = 1;
        double j = 2.0;
        ArrayList<int[]> res = new ArrayList<>();
        while (i < j) {
            j = (-1 + Math.sqrt(1 + 4 * (2L * target + (long) i * i - i))) / 2;
            if (i < j && j == (int) j) {
                int[] ans = new int[(int) j - i + 1];
                for (int k = i; k <= (int) j; k++) {
                    ans[k - i] = k;
                }
                res.add(ans);
            }
            i++;
        }
        return res.toArray(new int[0][]);
    }


    //滑动窗口(双指针)
    public int[][] findContinuousSequence1(int target) {
        int i = 1, j = 2, s = 3;
        ArrayList<int[]> res = new ArrayList<>();
        while (i < j) {
            if (s == target) {
                int[] ans = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    ans[k - i] = k;
                }
                res.add(ans);
            }
            if (s >= target) {
                s -= i;
                i++;
            } else {
                j++;
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }
}
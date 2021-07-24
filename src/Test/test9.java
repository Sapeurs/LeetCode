package Test;

/**
 * @author: Sapeurs
 * @date: 2021/5/8 16:35
 * @description:
 */
public class test9 {
}


class Solution1 {
    public int GetMaxCoverage(int[] populationDistribute, int stationCoverage) {
        // write code here
        int pop = 0;
        for (int i = 0; i < 4; i++) {
            int[] max = getMax(populationDistribute, stationCoverage);
            pop += max[0];

        }
        return pop;
    }

    public int[] getMax(int[] nums, int k) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < nums.length - k * 2; i++) {
            int sum = 0;
            for (int j = 0; j <= i + k * 2; j++) {
                sum += nums[j];
            }
            if (max < sum) {
                max = sum;
                index = i;
            }
        }
        int[] ints = new int[2];
        ints[0] = max;
        ints[1] = index;
        return ints;
    }
}
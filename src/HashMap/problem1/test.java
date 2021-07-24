package HashMap.problem1;

import java.util.HashMap;
import java.util.Map;

/***
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 */

public class test {
    public static void main(String[] args) {

    }
}

//暴力：枚举
class Solution1 {
    public int[] twoSum(int[] nums, int target) {

        return new int[0];
    }
}


class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
package HashMap.problem5;

import java.util.HashSet;
import java.util.Set;

public class test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(solution.findRepeatNumber(nums));
    }

}


class Solution {
    public int findRepeatNumber(int[] nums) {
        Set hashSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                return nums[i];
            }
            hashSet.add(nums[i]);
        }
        return 0;
    }
}
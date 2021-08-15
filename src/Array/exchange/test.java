package Array.exchange;

public class test {
}


class Solution {
    public int[] exchange(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, j = 0, k = nums.length - 1; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                result[j] = nums[i];
                j++;
            } else {
                result[k] = nums[i];
                k--;
            }
        }
        return result;
    }
}
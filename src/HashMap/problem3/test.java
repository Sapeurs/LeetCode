package HashMap.problem3;


import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] nums = new int[]{2,4,1,1,2};
//        System.out.println(solution.singleNumber(nums));
        int n = 10;
        System.out.println(n / 10);
    }
}


class Solution {
    public int singleNumber(int[] nums) {
        int i = 0;
        int j = 1;
        int n = nums.length;
        if (n > 1) {
            while (i < n) {
                if (nums[i] != nums[j]) {
                    j++;
                } else {
                    nums[j] = nums[n - 1];
                    n--;
                    i++;
                    j = i + 1;
                }
                if (j == n) {
                    break;
                }
            }
        }
        return nums[i];
    }
}
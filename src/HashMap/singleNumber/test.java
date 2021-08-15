package HashMap.singleNumber;


/**
 * 136. 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，
 * 其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 */

public class test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2,4,1,1,2};
        System.out.println(solution.singleNumber(nums));
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


    public int singleNumber1(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
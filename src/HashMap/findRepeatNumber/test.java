package HashMap.findRepeatNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Sapeurs
 * @date: 2021/7/12 21:27
 * @description: 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 */
public class test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(solution.findRepeatNumber2(nums));
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

    //直接在原数组修改
    public int findRepeatNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]){
                if (nums[i] == nums[nums[i]])
                    return nums[i];
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[tmp] = tmp;

            }
        }
        return 0;
    }

    //不修改原数组
    public int findRepeatNumber2(int[] nums) {
        int len = nums.length;
        int start = 1, end = len - 1;
        while (end>=start){
            int mid = ((end-start) >> 1) + start;
            int count = countRange(nums,len,start,mid);
            if (end == start){
                if (count>1)
                    return start;
                else
                    break;
            }
            if (count>(mid-start+1))
                end = mid;
            else
                start = mid+1;
        }
        return -1;
    }

    private int countRange(int[] nums, int length, int start, int end){
        if (nums == null) return 0;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i]>=start&&nums[i]<=end)
                count++;
        }
        return count;
    }
}
package Search.searchRange;

import java.util.Arrays;

/**
 * @author: Sapeurs
 * @date: 2021/4/19 21:49
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 */
public class test {
    public static void main(String[] args) {
        int[] nums = {4, 5, 7, 7, 7, 8, 8, 8, 8, 10};
        Solution solution = new Solution();
        int[] ints = solution.searchRange(nums, 8);
        System.out.println(Arrays.toString(ints));
    }
}


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);//第一个等于 target 的位置
        int rightIdx = binarySearch(nums, target, false) - 1;//第一个大于 target 的位置减一
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    //如果lower为true，则查找第一个大于等于target的下标，否则查找第一个大于target的下标
    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                //lower=true时如果nums[mid]>=target，继续寻找左边是否还有等于target的值
                //lower=false时如果nums[mid] > target，说明target最后一个出现的在mid左边
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
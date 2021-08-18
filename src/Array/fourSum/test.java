package Array.fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Spaeurs
 * @date: 2021/8/17 20:52
 * @description: 18. 四数之和
 *
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]] ：
 *
 * 0 <= a, b, c, d< n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0).toString());
    }
}


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            List<List<Integer>> ans = threeSum(nums, i + 1, target-nums[i]);
            for (List<Integer> list :ans) {
                list.add(nums[i]);
                res.add(list);
            }
            while (i < len - 1 && nums[i] == nums[i+1]) i++;
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums, int start, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = start; i < len; i++) {
            List<List<Integer>> ans = twoSumTarget(nums, i + 1, target-nums[i]);
            for (List<Integer> list :ans) {
                list.add(nums[i]);
                res.add(list);
            }
            while (i < len - 1 && nums[i] == nums[i+1]) i++;
        }
        return res;
    }

    List<List<Integer>> twoSumTarget(int[] nums, int start, int target){
        int low = start, high = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (low < high){
            int sum = nums[low] + nums[high];
            int left = nums[low], right = nums[high];
            if (sum < target){
                while (low<high && nums[low] == left) low++;
            } else if (sum > target){
                while (low < high && nums[high] == right) high--;
            }else {
                res.add(new ArrayList<>(Arrays.asList(left,right)));
                while (low<high && nums[low] == left) low++;
                while (low < high && nums[high] == right) high--;
            }
        }
        return res;
    }
}
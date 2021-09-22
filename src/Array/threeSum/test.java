package Array.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Spaeurs
 * @date: 2021/8/17 19:47
 * @description: 15. 三数之和
 *
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
 * 使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}).toString());
    }
}


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            List<List<Integer>> ans = twoSumTarget(nums, i + 1, -nums[i]);
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


    //排序+双指针
    public List<List<Integer>> threeSum1(int[] nums) {
        //首先应对数组排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //k指针由左至右遍历，右边至少有两个值
        for (int k = 0; k < nums.length - 2; k++) {
            //如果nums[k]>0，表明右边没有与nums[k]相加等于0的数字组合
            if (nums[k] > 0) break;
            //如果有多个nums[k],取最后一个
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0){//sum<0,i指针右移，增加sum
                    while (i < j && nums[i] == nums[i+1]){ //如果有多个nums[i],取最后一个
                        i++;
                    }
                }else if (sum > 0){//sum>0,j指针左移，减小sum
                    while (i < j && nums[j] == nums[j-1]){//如果有多个nums[j],取最前一个
                        j--;
                    }
                }else {
                    //找到一种组合
                    res.add(new ArrayList<>(Arrays.asList(nums[k],nums[j],nums[i])));
                    //进行去重
                    while (i < j && nums[i] == nums[i+1]) i++;
                    while (i < j && nums[j] == nums[j-1]) j--;
                }
            }
        }
        return res;
    }
}
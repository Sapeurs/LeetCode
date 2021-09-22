package Array.removeDuplicates;

/**
 * @author: Spaeurs
 * @date: 2021/9/17 15:47
 * @description: 26. 删除有序数组中的重复项
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
 * 返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 */
public class test {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 4, 4}));
    }
}



class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (fast<nums.length){
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
}
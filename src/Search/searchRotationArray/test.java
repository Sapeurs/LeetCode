package Search.searchRotationArray;

/**
 * @author: Sapeurs
 * @date: 2021/4/21 8:36
 * @description: 33. 搜索旋转排序数组
 * 数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * （下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，
 * 否则返回-1。
 */
public class test {
    public static void main(String[] args) {
        int[] nums = {1};
        Solution solution = new Solution();
        int ans = solution.search(nums, 1);
        System.out.println(ans);
    }
}


class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length - 1;
        int left = 0, right = len, mid, ans;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[len] == target) {
            ans = len;
        } else if (nums[len] > target) {
            ans = binarySearch(nums, left, len, target);
        } else {
            ans = binarySearch(nums, 0, left, target);
        }
        return ans;
    }

    int binarySearch(int[] nums, int left, int right, int target) {
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
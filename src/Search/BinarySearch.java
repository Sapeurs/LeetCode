package Search;

/**
 * @author: Sapeurs
 * @date: 2021/3/30 12:56
 * @description: 实现二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 5, 5, 5, 6, 8, 9};
        System.out.println(search(nums, 5));
    }

    //非递归实现
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    //递归实现
    public static int halfSearch(int[] arr, int left, int right, int target) {
        int mid = left + (right - left) / 2; //防止整型溢出

        int midValue = arr[mid];

        if (left <= right) {
            if (midValue > target) {
                return halfSearch(arr, left, mid - 1, target);
            } else if (midValue < target) {
                return halfSearch(arr, mid + 1, right, target);
            } else {
                return mid;
            }
        }
        return -1;
    }
}
package Search.problem6;

/**
 * @author: Sapeurs
 * @date: 2021/7/5 20:10
 * @description: 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * <p>
 * 统计一个数字在排序数组中出现的次数。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(solution.search(nums, 6));
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int index = binarySearch(nums, target);
        int res = 1;
        if (index == -1) return 0;
        else {
            int i = index - 1, j = index + 1;
            while (i >= 0 && nums[i] == target) {
                i--;
                res++;
            }
            while (j < nums.length && nums[j] == target) {
                j++;
                res++;
            }
        }
        return res;
    }

    int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    //查找数字tar在数组中的右边界
    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
package sort.sortArrayByParityII;

public class test {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] ints = {4, 2, 5, 7};
        int[] result = solution2.sortArrayByParityII(ints);
        for (int j : result) {
            System.out.println(j);
        }

    }
}


class Solution {
    public int[] sortArrayByParityII(int[] nums) {

        int[] result = new int[nums.length];
        int[] nums1 = new int[nums.length];
        for (int i = 0, j = 0, k = nums.length / 2; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                nums1[j] = nums[i];
                j++;
            } else {
                nums1[k] = nums[i];
                k++;
            }
        }
        for (int i = 0, j = 0, k = nums.length / 2; i < nums1.length; i++) {
            if (i % 2 == 0) {
                result[i] = nums1[j];
                j++;
            } else {
                result[i] = nums1[k];
                k++;
            }
        }
        return result;
    }
}


class Solution2 {
    public int[] sortArrayByParityII(int[] nums) {

        int[] result = new int[nums.length];

        for (int i = 0, j = 0, k = 1; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result[j] = nums[i];
                j += 2;
            } else {
                result[k] = nums[i];
                k += 2;
            }
        }
        return result;
    }
}
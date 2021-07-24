package Stack.problem1;


import java.util.*;

/**
 * @author: Sapeurs
 * @date: 2021/3/30 21:48
 * @description: 给你两个没有重复元素的数组nums1和nums2，其中nums1是nums2的子集。
 * 请你找出nums1中每个元素在nums2中的下一个比其大的值。
 */
public class test {
    public static void main(String[] args) {

        Solution3 solution = new Solution3();
        int[] nums1 = {2, 4};
        int[] nums2 = {2, 6, 4, 8, 3, 1};
        int[] result = solution.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            hashMap.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            boolean flag = false;
            for (int j = hashMap.get(nums1[i]); j < nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    result[i] = nums2[j];
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                result[i] = -1;
            }
        }
        return result;
    }
}

class Solution2 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] res = new int[len1];
        if (len1 < 1) {
            return res;
        }

        for (int i = 0; i < len1; i++) {
            int curVal = nums1[i];
            int j = 0;
            while (j < len2 && nums2[j] != curVal) {
                j++;
            }

            // 此时 nums[j] = nums[i]
            j++;
            while (j < len2 && nums2[j] < curVal) {
                j++;
            }
            if (j == len2) {
                res[i] = -1;
                continue;
            }
            res[i] = nums2[j];
        }
        return res;
    }
}


/*
先对num2的每一个元素，求出它的右边第一个更大的元素，将这个关系放入哈希表中，
再遍历数组nums1，根据哈希表找出答案
 */
class Solution3 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 先处理 nums2，把对应关系存入哈希表
        for (int i = 0; i < len2; i++) {
            while (!stack.isEmpty() && stack.peekLast() < nums2[i]) {
                map.put(stack.removeLast(), nums2[i]);
            }
            stack.addLast(nums2[i]);
        }

        // 遍历 nums1 得到结果集
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
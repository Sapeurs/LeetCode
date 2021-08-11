package Stack.nextGreaterElements;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: Sapeurs
 * @date: 2021/3/31 10:44
 * @description: 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），
 * 输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，
 * 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 */
public class test {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums2 = {1, 5, 4, 3, 2};
        int[] result = solution.nextGreaterElements(nums2);
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len * 2 - 1; i++) {
            int temp = nums[i % len];
            while (!deque.isEmpty() && temp > nums[deque.peek()]) {
                int prevIndex = deque.pop();//移除栈顶元素并返回
                ans[prevIndex] = temp;
            }
            deque.push(i % len);
        }
        return ans;
    }
}
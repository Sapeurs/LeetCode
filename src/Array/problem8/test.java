package Array.problem8;

/**
 * @author: Sapeurs
 * @date: 2021/6/28 21:40
 * @description: 剑指 Offer 11. 旋转数组的最小数字
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 3, 1, 3};
        System.out.println(solution.minArray(arr));
    }
}


class Solution {
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1, mid = (l + r) / 2;
        while (l != r) {
            if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else if (numbers[mid] < numbers[r]) {
                r = mid;
            } else {
                r--;
            }
            mid = (l + r) / 2;
        }
        return numbers[mid];
    }
}
package HashMap.problem8;


import java.util.HashSet;
import java.util.Set;

/***
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        int[] result = solution.intersection(num1, num2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> sameSet = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        for (Integer i : set1
        ) {
            if (set2.contains(i)) {
                sameSet.add(i);
            }
        }

        Object[] obj = sameSet.toArray();
        int[] ints = new int[sameSet.size()];
        for (int i = 0; i < obj.length; i++) {
            ints[i] = (int) obj[i];
        }
        return ints;
    }
}
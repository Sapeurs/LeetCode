package sort.someSort;

import java.util.Arrays;

/**
 * @author: Sapeurs
 * @date: 2021/4/4 19:44
 * @description: 选择排序    平均时间复杂度：O(n2)
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 1, 4, 0, 22, 14};
        select_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void select_sort(int[] array) {
        int len = array.length;

        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

}
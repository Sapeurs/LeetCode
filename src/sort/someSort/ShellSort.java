package sort.someSort;

import java.util.Arrays;

/**
 * @author: Sapeurs
 * @date: 2021/4/5 13:35
 * @description: 希尔排序  时间复杂度O(n^(1.3-2))
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {5, 9, 2, 4, 0, 8, 1, 3, 7, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int gap = arr.length / 2;

        while (gap >= 1) {
            //把距离为gap的元素编为一个组，扫描所有组
            for (int i = gap; i < arr.length; i++) {
                int j = 0;
                int temp = arr[i];

                //对距离为gap的元素组进行排序
                for (j = i - gap; j >= 0 && temp < arr[j]; j = j - gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }
            //减小增量
            gap = gap / 2;
        }
    }
}

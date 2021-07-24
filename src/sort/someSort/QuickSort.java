package sort.someSort;

import java.util.Arrays;

/**
 * @author: Sapeurs
 * @date: 2021/3/30 14:01
 * @description: 快速排序      平均时间复杂度：O(N*logN)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 9, 5, 7, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {

        if (left >= right)
            return;

        int i = left, j = right, key = arr[i];

        while (i < j) {
            while (i < j && arr[j] >= key) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && key >= arr[i]) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = key;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    /*
        public static void quickSort(int[] a, int left, int right) {
        if (left >= right)
            return;

        int i = left, j = right, key = a[i];//选择第一个数为key

        while (i < j) {
            while (i < j && a[j] >= key)
                j--;
            if (i < j) {
                a[i] = a[j];
                i++;
            }

            while (i < j && a[i] < key)
                i++;
            if (i < j) {
                a[j] = a[i];
                j--;
            }
        }
        //i==j
        a[i] = key;
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }
     */
}
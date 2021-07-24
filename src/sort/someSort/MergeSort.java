package sort.someSort;

import java.util.Arrays;

/**
 * @author: Sapeurs
 * @date: 2021/4/5 20:18
 * @description: 归并排序  平均时间复杂度：O(NlogN)
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 9, 2, 4, 0, 8, 1, 3, 7, 6};
        merge_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //递归方法
    public static void mergeSort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        merge_sort_recursive(arr, result, 0, len - 1);
    }

    static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;//len >> 1 == len/2
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            result[k++] = arr[start1++];
        while (start2 <= end2)
            result[k++] = arr[start2++];
        for (k = 0; k <= end; k++) {
            arr[k] = result[k];
        }
    }

    //######################################################################################
    //迭代方法
    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        int block, start;

        for (block = 1; block < len * 2; block *= 2) {
            for (start = 0; start < len; start += 2 * block) {
                int low = start;
                int mid = Math.min((start + block), len);
                int high = Math.min((start + 2 * block), len);
                //两个分组的起始下标及结束下标
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;
                //开始对两个block进行归并排序
                while (start1 < end1 && start2 < end2)
                    result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
                while (start1 < end1)
                    result[low++] = arr[start1++];
                while (start2 < end2)
                    result[low++] = arr[start2++];
            }
            int[] temp = arr;
            arr = result;
            result = temp;
        }
        result = arr;
    }


    //将有序数组a[]和b[]合并到c[]中
    static void merge_array(int[] a, int[] b, int[] c) {
        int i, j, k;
        i = j = k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j])
                c[k++] = a[i++];
            else
                c[k++] = b[j++];
        }
        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = b[j++];
        }
    }
}
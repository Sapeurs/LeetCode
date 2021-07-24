package sort.someSort;

import java.util.Arrays;

/**
 * @author: Sapeurs
 * @date: 2021/3/29 21:20
 * @description: 插入排序   平均时间复杂度：O(n2)
 */
public class InsertSort {
    public static void main(String[] args) {
        InsertSort(new int[]{9, 20, 10, 13, 12});
    }

    public static void InsertSort(int[] arr) {
        int value;//待插入元素
        int index;//初始值为待插入元素前一个元素的索引

        for (int i = 1; i < arr.length; i++) {
            //i从第二个元素开始，默认第一个元素是有序的
            //循环条件是小于数组长度，因为也要将最后一个元素插入到前面的序列
            value = arr[i];
            index = i - 1;//初始为前一个元素
            while (index >= 0 && value < arr[index]) {
                //需要保证index合法
                //每当前面的元素比待插入元素大，就向后移动
                arr[index + 1] = arr[index];
                //不用怕覆盖，因为value保存着待插入的值
                index--;
            }
            //当退出循环，表明已经找到了待插入位置，即index + 1
            arr[index + 1] = value;
        }

        System.out.println(Arrays.toString(arr));


    }
}
package sort.findKthLargest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: Spaeurs
 * @date: 2021/9/19 16:24
 * @description: 215. 数组中的第K个最大元素
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 */
public class test {
}


class Solution {
    //快排
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length - 1);
        return nums[nums.length - k];
    }

    void quickSort(int[] nums, int left, int right){
        if (left >= right) return;
        int i = left, j = right, key = nums[left];
        while (i < j){
            while (i < j && nums[j] >= key){
                j--;
            }
            nums[i] = nums[j];
            while (i<j && nums[i] <= key){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = key;
        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);
    }

    //优先队列
    public int findKthLargest1(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < len; i++) {
            Integer top = minHeap.peek();
            //只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
            if (nums[i] > top){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }

    //手写最小堆排序实现
    public int findKthLargest2(int[] nums, int k) {
        return sort(nums,k);
    }

    private int sort(int[] arr, int k){
        //构建最大的K个值的小顶堆
        int len = arr.length;
        int[] sort = new int[k];
        if (k >= 0) System.arraycopy(arr, 0, sort, 0, k);
        //先构建最初的小顶堆
        for (int i = k/2-1; i >= 0; i--) {
            //从第一个非叶子节点从下至上，从左至右调整结构
            adjustHeapSmall(sort,i,k);
        }
        //其他元素录入
        for (int i = k; i < len; i++) {
            //如果当前值比堆中最小值还小，那就continue
            //否则替换掉重新排序
            if (sort[0] < arr[i]){
                sort[0] = arr[i];
                for (int j = k/2 - 1; j >= 0; j--) {
                    //从第一个非叶子节点从下至上，从左至右调整结构
                    adjustHeapSmall(sort,j,k);
                }
            }
        }
        return sort[0];
    }

    private void adjustHeapSmall(int[] arr, int i, int length){
        int tmp = arr[i]; //先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            /*
            从i节点的左子节点，也就是2i+1处开始
            k用于获取当前i节点的两个子节点中较大的那一个
            k+1<length过滤的是仅有一个节点的情况
             */
            if (k + 1 < length && arr[k] > arr[k+1]) {
                k++;
            }
            /*
            如果子节点k小于父节点i，就先把父节点的值覆盖掉
            并且将k作为新的父节点，向下循环去查看是否有比k更小的子节点
             */
            if (arr[k] < tmp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        //当比较结束之后，把最初的tmp中存储的父节点i的值赋给更新后的i节点
        arr[i] = tmp;
    }

}
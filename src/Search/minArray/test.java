package Search.minArray;

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
            if (numbers[mid] > numbers[r])
                l = mid + 1;
             else if (numbers[mid] < numbers[r])
                r = mid;
             else
                r--;
            mid = (l + r) / 2;
        }
        return numbers[mid];
    }

    //直观写法
    public int minArray1(int[] numbers) {
        int l = 0, r= numbers.length-1, mid = l;
        while (numbers[l]>=numbers[r]){
            //两个指针距离为1，表示l已经指向第一个递增数组的末尾，r指向第二个递增数组的开头
            if (r - l == 1) {
                //返回r
                mid = r;
                break;
            }

            mid = (l + r) / 2;

            //如果l,r,mid三个指针指向的数字相等，无法判断，只能顺序查找
            if (numbers[l] == numbers[r] && numbers[mid] == numbers[l]){
                return minOrder(numbers,l,r);
            }

            //如果l指向的数字小于mid指向的数字，说明最小元素位于mid后面
            if (numbers[l] <= numbers[mid])
                l = mid;
            //如果r指向的数字大于mid指向的数字，说明最小元素位于mid前面
            else if (numbers[r] >= numbers[mid])
                r = mid;
        }
        return numbers[mid];
    }

    //顺序查找
    int minOrder(int[] nums, int l, int r){
        int res = nums[l];
        for (int i = l+1; i <= r; i++) {
            res = Math.min(res,nums[i]);
        }
        return res;
    }

}
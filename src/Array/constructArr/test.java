package Array.constructArr;

/**
 * @author: Sapeurs
 * @date: 2021/7/12 21:27
 * @description: 剑指 Offer 66. 构建乘积数组
 * <p>
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即
 * B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 */
public class test {
}


class Solution {
    //超时
    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int mul = 1;
            for (int j = 0; j < len; j++) {
                if (i != j)
                    mul *= a[j];
            }
            res[i] = mul;
        }
        return res;
    }

    public int[] constructArr1(int[] a) {
        int len = a.length;
        if (len == 0) return new int[0];
        int[] b = new int[len];
        b[0] = 1;
        int tmp = 1;
        for (int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
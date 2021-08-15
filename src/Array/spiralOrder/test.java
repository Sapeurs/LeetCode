package Array.spiralOrder;

import java.util.Arrays;

/**
 * @author: Sapeurs
 * @date: 2021/7/7 20:23
 * @description: 剑指 Offer 29. 顺时针打印矩阵
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}};
        int[][] matrix1 = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(Arrays.toString(solution.spiralOrder(matrix)));
    }
}


class Solution {
//    public int[] spiralOrder1(int[][] matrix) {
//        int row = matrix.length, col = matrix[0].length;
//        if ((row * col) == 0) return new int[0];
//        int[] res = new int[row * col];
//        int idx = 0;
//        for (int i = 0; i < row/2 + 1; i++) {
//            int j = i, k = i;
//            for (; k < col - i - 1; k++, idx++) {
//                res[idx] = matrix[j][k];
//            }
//            for (; j < row - i - 1; j++, idx++) {
//                res[idx] = matrix[j][k];
//            }
//            for (; k > i; k--, idx++) {
//                res[idx] = matrix[j][k];
//            }
//            for (; j > i; j--, idx++) {
//                res[idx] = matrix[j][k];
//            }
//        }
//        return res;
//    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i];
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r];
            if (l > --r) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i];
            if (t > --b) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l];
            if (++l > r) break;
        }
        return res;
    }
}
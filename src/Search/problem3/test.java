package Search.problem3;

/**
 * @author: Sapeurs
 * @date: 2021/6/29 20:21
 * @description: 剑指 Offer 04. 二维数组中的查找
 * <p>
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入
 * 这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class test {
}


class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int n = 0, m = matrix[0].length - 1;
        while (n < matrix.length && m >= 0) {
            if (matrix[n][m] > target) {
                m--;
            } else if (matrix[n][m] < target) {
                n++;
            } else {
                return true;
            }
        }
        return false;
    }
}
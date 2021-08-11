package sort.average;



/**
 * @author: Sapeurs
 * @date: 2021/7/11 21:17
 * @description: 1491. 去掉最低工资和最高工资后的工资平均值
 *
 * 给你一个整数数组salary，数组里每个数都是 唯一的，其中salary[i] 是第i个员工的工资。
 *
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 *
 *
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] salary = {4000, 3000, 1000, 2000};
        System.out.println(solution.average(salary));
    }
}


class Solution {
    public double average(int[] salary) {
        int max = 0;
        int min = salary[0];
        int sum = 0;
        for (int j : salary) {
            if (j > max) {
                max = j;
            }
            if (j < min) {
                min = j;
            }
            sum += j;
        }
        return (double) (sum - max - min) / (salary.length - 2);
    }
}
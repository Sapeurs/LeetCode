package sort.problem1;

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] salary = {4000, 3000, 1000, 2000};
        System.out.println(solution.average(salary));
        String s = "祝你考出好成绩！";
        System.out.println(s.length());
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
package Test.meituan;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/8/22 10:45
 * @description:
 */
public class test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.nextLine();
        int m = sc.nextInt();
        int[][] questions = new int[m][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                questions[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            if (questions[i][0] == 1){
                for (int j = questions[i][1] - 1; j < questions[i][2]; j++) {
                    ans[i]+=nums[j];
                }
            }else if (questions[i][0] == 2){
                int sum = 0;
                for (int j = questions[i][1] - 1; j < questions[i][2]; j++) {
                    sum+=nums[j];
                }
                for (int j = questions[i][1] - 1; j < questions[i][2]; j++) {
                    ans[i] += Math.pow(sum - nums[j],2);
                }
            }else {
                int max = Integer.MIN_VALUE;
                for (int j = questions[i][1] - 1; j < questions[i][2]; j++) {
                    max = Math.max(nums[j], max);
                }
                ans[i] = max;
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(ans[i]);
        }
    }
}
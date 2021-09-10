package Test.weBank;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/10 21:35
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] nums = new int[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        String commands = sc.next();
        int ans = 0;
        int i = 0;
        int first = 0, second = 0;
        while (i < commands.length()) {
            char c = commands.charAt(i);
            if (i > 0 && c != commands.charAt(i - 1))
                ans += x;
            if (c == 'h') {
                if (second == 0 || nums[first][second-1] == -1)
                    ans += y;
                else {
                    ans += Math.max(nums[first][second], nums[first][second - 1]);
                    second -= 1;
                }
            }
            if (c == 'j') {
                if (first == n - 1 || nums[first + 1][second] == -1)
                    ans += y;
                else {
                    ans += Math.max(nums[first][second], nums[first + 1][second]);
                    first += 1;
                }
            }
            if (c == 'k') {
                if (first == 0 || nums[first - 1][second] == -1)
                    ans += y;
                else {
                    ans += Math.max(nums[first][second], nums[first - 1][second]);
                    first -= 1;
                }
            }
            if (c == 'l') {
                if (second == m - 1 || nums[first][second + 1] == -1)
                    ans += y;
                else {
                    ans += Math.max(nums[first][second], nums[first][second + 1]);
                    second += 1;
                }
            }
            i++;
        }
        System.out.println(ans);
    }
}
package Test.leihuo;

import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/18 15:03
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n * m][5];
        int[][] val = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
            if (arr[i][1] == 0 && arr[i][2] == 0)
                val[0][0] = arr[i][0];
        }
        for (int i = 1; i <= m - 1; i++) {
            val[0][i] = find(val[0][i - 1], arr);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                val[j][i] = findx(val[j - 1][i], arr);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(val[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int find(int num, int[][] arr) {
        return arr[num - 1][3];
    }

    static int findx(int num, int[][] arr) {
        return arr[num - 1][4];
    }
}

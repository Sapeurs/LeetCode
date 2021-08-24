package Test.aiqiyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/8/22 15:50
 * @description:
 */
public class test1 {

    static List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = Integer.parseInt(s.substring(s.length() - 1));
        //初始化棋盘
        char[][] board = new char[n][n];
        for (char[] chars :
                board) {
            Arrays.fill(chars, '.');
        }
        trace(board, 0, n);
        System.out.println(res.toString());
    }

    static void trace(char[][] board, int row, int n) {
        if (row == n) {
            List<String> ans = generateBoard(board);
            res.add(new ArrayList(ans));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) continue;
            board[row][col] = 'Q';
            trace(board, row + 1, n);
            board[row][col] = '.';
        }
    }

    static List<String> generateBoard(char[][] board) {
        List<String> ans = new ArrayList<>();
        for (char[] chars : board) {
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                sb.append(c);
            }
            ans.add(sb.toString());
        }
        return ans;
    }

    static boolean isValid(char[][] board, int row, int col) {
        int len = board.length;
        for (int i = 0; i < len; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < len; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }
}


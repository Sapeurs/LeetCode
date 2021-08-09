package TraceBack.NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Spaeurs
 * @date: 2021/8/9 19:22
 * @description: 51. N 皇后
 *
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4).toString());
    }
}

class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //初始化棋盘
        char[][] board = new char[n][n];
        for (char[] chars :
                board) {
            Arrays.fill(chars,'.');
        }
        trace(board,0,n);
        return res;
    }


    void trace(char[][] board, int row, int n){
        if (row == n){
            List<String> ans = generateBoard(board);
            res.add(new ArrayList(ans));
            return;
        }
        for (int col = 0; col < n; col++) {
            //排除不合法的选择
            if (!isValid(board,row,col)) continue;
            //做选择
            board[row][col] = 'Q';
            //进入下一行决策
            trace(board,row+1,n);
            //撤销选择
            board[row][col] = '.';
        }

    }

    List<String> generateBoard(char[][] board){
        List<String> ans = new ArrayList<>();
        for (char[] chars : board) {
            ans.add(Arrays.toString(chars));
        }
        return ans;
    }

    /**
     * 判断是否可以在board[row][col]上放置皇后
     * @param board
     * @param row
     * @param col
     * @return
     */
    boolean isValid(char[][] board, int row, int col){
        int len = board.length;
        //检查列是否有皇后互相冲突
        for (int i = 0; i < len; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        //检查右上方是否有皇后相互冲突
        for (int i = row-1, j = col + 1; i >= 0 && j < len; i--,j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        //检查左上方是否有皇后相互冲突
        for (int i = row-1,j = col-1; i >=0 && j>=0; i--,j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }
}
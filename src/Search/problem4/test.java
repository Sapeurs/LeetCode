package Search.problem4;

/**
 * @author: Sapeurs
 * @date: 2021/6/29 20:59
 * @description: 剑指 Offer 12. 矩阵中的路径
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "BCCED";
        System.out.println(solution.exist(board, word));
    }
}


class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        //遍历查找第一个字符的位置
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    /**
     *
     * @param board
     * @param word
     * @param i
     * @param j
     * @param k 要寻找的第k个字符
     * @return
     */
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        //如果i,j超出边界或者board[i][j]不等于work中第k个字符时，返回false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k])
            return false;
        //已经找到最后一个字符
        if (k == word.length - 1)
            return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }
}
package leetcode.fiftyone_onehundres;

import java.util.ArrayList;
import java.util.List;

public class A_51_NQueens {
    public static void main(String[] args) {
        List<List<String>> list = solveNQueens(4);
        for (List<String> l : list) {
            for (String s : l) {
                System.out.println(s);
            }
            System.out.println();
            System.out.println();
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        dfs(board, 0, res);
        return res;
    }

    public static void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if (colIndex == board.length) { //it is colIndex == board[0].length, but board.length == board[0].length = n
            res.add(construct(board));
            return;
        }
        for (int i = 0; i < board.length; i++) { // loop from top to bottom
            if (validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }
    }

    public static boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i)) {
                    // x+j == y+i: diagonal \
                    // x+y == i+j: diagonal /
                    // x == i: same line
                    // no need to check column, as backtracking, reverse from 'Q' to '.'
                    return false;
                }
            }
        }
        return true;
    }

    public static List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            list.add(s);
        }
        return list;
    }
}

/*
Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */

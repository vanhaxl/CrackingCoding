package leetcode.one00_one50;

import java.util.Arrays;

public class A_130_SurroundedRegions {
    public static  void main(String[] args){
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'O', 'X'}
        };

        solve(board);
        for(char[] arr: board){
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void solve(char[][] board){
        if(board == null || board.length == 0 || board[0].length == 0) return;

        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i< n; i++){
            if(board[0][i] == 'O'){
                dfs(board, 1, i);
            }
        }
        for(int i = 1; i< m; i++){
            if(board[i][n-1] == 'O'){
                dfs(board, i, n-2);
            }
        }

        for(int i = n-1; i>= 0; i--){
            if(board[m-1][i] == 'O'){
                dfs(board, m-2, i);
            }
        }

        for(int i = 1; i<= m-2; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 1);
            }
        }

        for(int i = 1; i< m-1; i++){
            for(int j = 1; j< n-1; j++){
                if(board[i][j] == '1'){
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }


    }

    public static void dfs(char[][] board, int i , int j){
        if(i <= 0 || i >= board.length - 1 || j <= 0 || j >= board[0].length -1 || board[i][j] != 'O')
            return;
        board[i][j] = '1';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }
}

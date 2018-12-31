package leetcode.one_fifty;

import java.util.HashSet;
import java.util.Set;

public class A_36_ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '4', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '4'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));

    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidArray(board[i])) return false;
        }
        for (int i = 0; i < 9; i++) {
            char[] arr = new char[9];
            for (int j = 0; j < 9; j++) {
                arr[j] = board[j][i];
            }
            if (!isValidArray(arr)) return false;
        }
        for(int i = 0; i<9; i=i+3){
            for(int j = 0; j< 9; j=j+3){
                if(!isValidateSquare(board, i, j)) return false;
            }

        }
        return true;
    }

    public static boolean isValidArray(char[] arr) {
        Set<Character> set = new HashSet<>();
        for (char x : arr) {
            if (x != '.') {
                if (set.contains(x)) return false;
                set.add(x);
            }
        }
        return true;
    }

    public static boolean isValidateSquare(char[][] arr, int x, int y){
        Set<Character> set = new HashSet<>();
        for(int i = x; i< x+3; i++){
            for(int j = y; j < y+3; j++){
                if(arr[i][j] != '.'){
                    if(set.contains(arr[i][j])) return false;
                    set.add(arr[i][j]);
                }
            }
        }
        return true;
    }
}

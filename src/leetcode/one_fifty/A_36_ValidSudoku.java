package leetcode.one_fifty;

import java.util.HashSet;
import java.util.Set;

public class A_36_ValidSudoku {

    public static void main(String[] args) {

    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i< 9; i++){
            if(!isValidArray(board[i])) return false;
        }
        for(int i = 0; i< 9; i++){
            char[] arr = new char[9];
            for(int j = 0; j< 9; j++){
                arr[j] = board[i][j];
            }
            if(!isValidArray(arr)) return false;
        }
        return true;
    }

    public static boolean isValidArray(char[] arr) {
        Set<Character> set = new HashSet<>();
        for (char x : arr) {
            if (set.contains(x)) return false;
            set.add(x);
        }
        return true;
    }
}

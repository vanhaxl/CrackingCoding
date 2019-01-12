package leetcode.fiftyone_onehundres;

import java.util.Arrays;

public class A_73_SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {
                        0, 1, 2, 0
                },
                {
                        3, 4, 5, 2
                },
                {
                        1, 3, 1, 5
                }
        };
        setZeroes(matrix);
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }

    }

    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return ;
        int col0 = 1;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0|| matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) matrix[i][0] = 0;
        }
    }
}

/*
store states of each row in the first of that row, and store states of each column in the first of that column.
Because the state of row0 and the state of column0 would occupy the same cell, I let it be the state of row0,
and use another variable "col0" for column0. In the first phase,
use matrix elements to set states in a top-down way. In the second phase, use states to set matrix elements in a bottom-up way.
 */

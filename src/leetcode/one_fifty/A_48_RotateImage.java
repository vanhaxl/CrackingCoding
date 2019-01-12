package leetcode.one_fifty;

import java.util.Arrays;

public class A_48_RotateImage {
    public static void main(String[] args){
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        rotate(matrix);
        for(int[] arr: matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }
    public static void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int tmp = 0;
        int len = matrix.length;
        for(int i = 0; i< matrix.length; i++){ //flip symmetric
            for(int j = i; j< matrix[0].length; j++){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for(int i = 0; i< matrix.length; i++){ // swap columns
            for(int j = 0; j< matrix[0].length/2; j++){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len-j-1];
                matrix[i][len-j-1] = tmp;
            }
        }
    }
}

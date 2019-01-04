package leetcode.three00_three50;

class NumMatrix {
    // O(1) space
    int[][] mMatrix = null;
    int m = 0;
    int n = 0;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        mMatrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        // rowSums[i][j] = rowSums[i][0] + rowSums[i][1] + ... + rowSums[i][j]
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i][j] + matrix[i][j - 1];
            }
        }
    }
    // O(n)
    public void update(int row, int col, int val) {
        // handle col = 0 differently
        int originalValue = col == 0 ? mMatrix[row][0] : mMatrix[row][col] - mMatrix[row][col - 1];
        int diff = val - originalValue;
        for (int j = col; j < n; j++) {
            mMatrix[row][j] += diff;
        }
    }
    // O(m)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int i = row1; i <= row2; i++) {
            // handle col = 0 differently
            result += col1 == 0 ? mMatrix[i][col2] : mMatrix[i][col2] - mMatrix[i][col1 - 1];
        }
        return result;
    }
}
public class A_308_RangeSumQuery2D {
    public static void main(String[] args){
        int[][] arr = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};

        NumMatrix numMatrix = new NumMatrix(arr);
        int a = numMatrix.sumRegion(2, 1, 4, 3);
        System.out.println(a);
        numMatrix.update(3, 2, 2);
        a = numMatrix.sumRegion(2, 1, 4, 3);
        System.out.println(a);

    }
}

        //sumRegion(2, 1, 4, 3) -> 8
        //update(3, 2, 2)
        //sumRegion(2, 1, 4, 3) -> 10
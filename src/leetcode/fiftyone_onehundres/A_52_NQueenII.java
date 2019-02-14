package leetcode.fiftyone_onehundres;

public class A_52_NQueenII {

    static int count = 0;

    public static void main(String[] args) {
        System.out.println(totalNQueens(1));
    }

    public static int totalNQueens(int n) {
        boolean[] cols = new boolean[n]; // columns   |
        boolean[] d1 = new boolean[2 * n]; // diagonal \
        boolean[] d2 = new boolean[2 * n]; // diagonal /
        backtrack(0, cols, d1, d2, n);
        return count;
    }

    public static void backtrack(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
        if (row == n) count++;
        for (int col = 0; col < n; col++) {
//            System.out.println("row: " + row);
//            System.out.println("col: " + col);

            int id1 = col - row + n;
            int id2 = col + row;
//            System.out.println("id1: " + id1);
//            System.out.println("id2: " + id2);
           // System.out.println();
            if (cols[col] || d1[id1] || d2[id2]) continue;
            cols[col] = true;
            d1[id1] = true;
            d2[id2] = true;
            backtrack(row + 1, cols, d1, d2, n);
            cols[col] = false;
            d1[id1] = false;
            d2[id2] = false;
        }

    }
}

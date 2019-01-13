package leetcode.three00_three50;


class TicTacToe {
    char[][] matrix;
    int[][] rowCount;
    int[][] colCount;
    int[] diagonal1; //00 11 22
    int[] diagonal2; //02 11 20
    int n;

    public TicTacToe(int n) {
        matrix = new char[n][n];
        rowCount = new int[n][2];
        colCount = new int[n][2];
        diagonal1 = new int[2];
        diagonal2 = new int[2];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        if (++rowCount[row][player - 1] == n) return player;
        if (++colCount[col][player - 1] == n) return player;
        if (row == col) {
            if (++diagonal1[player - 1] == n) return player;
        }
        if (row + col + 1 == n) {
            if (++diagonal2[player - 1] == n) return player;
        }
        return 0;

    }
}

public class A_348_DesignTicTacToe {
    public static void main(String[] args) {
        TicTacToe toe = new TicTacToe(3);
        System.out.println(toe.move(0, 0, 1));
        System.out.println(toe.move(0, 2, 2));
        System.out.println(toe.move(2, 2, 1));
        System.out.println(toe.move(1, 1, 2));
        System.out.println(toe.move(2, 0, 1));
        System.out.println(toe.move(1, 0, 2));
        System.out.println(toe.move(2, 1, 1));
    }

}

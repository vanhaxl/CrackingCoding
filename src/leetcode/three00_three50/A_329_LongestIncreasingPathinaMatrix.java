package leetcode.three00_three50;


public class A_329_LongestIncreasingPathinaMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}};
        System.out.println(longestIncreasingPath(arr));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }

    public static int longestIncreasingPath(int[][] arr) {
        if (arr.length == 0) return 0;
        int[][] memo = new int[arr.length][arr[0].length];

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                max = Math.max(max, helper(arr, i, j, memo));
            }
        }
        return max;
    }

    public static int helper(int[][] arr, int x, int y, int[][] memo) {
        if (memo[x][y] != 0) return memo[x][y];
        if (x + 1 < arr.length && arr[x + 1][y] > arr[x][y]) {
            memo[x][y] = Math.max(memo[x][y], helper(arr, x + 1, y, memo));
        }
        if (x - 1 >= 0 && arr[x - 1][y] > arr[x][y]) {
            memo[x][y] = Math.max(memo[x][y], helper(arr, x - 1, y, memo));
        }
        if (y + 1 < arr[0].length && arr[x][y + 1] > arr[x][y]) {
            memo[x][y] = Math.max(memo[x][y], helper(arr, x, y + 1, memo));
        }
        if (y - 1 >= 0 && arr[x][y - 1] > arr[x][y]) {
            memo[x][y] = Math.max(memo[x][y], helper(arr, x, y - 1, memo));
        }
        return ++memo[x][y];

    }
}

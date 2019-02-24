package leetcode.a_1000_a_1050;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A_1001_GridIllumination {
    public static void main(String[] args) {
        int[][] lamps = {{0, 0}, {4, 4}};
        int[][] queries = {{1, 1}, {1, 0}};
        int[] result = gridIllumination(5, lamps, queries);
        System.out.println(Arrays.toString(result));
    }

    public static int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        int[] result = new int[queries.length];
        int index = 0;
        //build matrix
        int[][] matrix = new int[n][n];
        for (int[] arr : lamps) {
            matrix[arr[0]][arr[1]] = 2;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == arr[0] || j == arr[1] || i + j == arr[0] + arr[1] || arr[0] + j == arr[1] + i) {
                        if (matrix[i][j] == 0)
                            matrix[i][j] = 1;
                    }
                }
            }
        }

        //
        for (int[] query : queries) {
            result[index++] = matrix[query[0]][query[1]] == 0 ? 0 : 1;
            //set all 8-adjacent off
            turnOff8Light(matrix, query[0], query[1]);

        }
        return result;
    }

    public static void turnOff8Light(int[][] matrix, int x, int y) {
        if (matrix[x][y] == 2) {
            matrix[x][y] = 0;
            reset(matrix, x, y);
        }
        if (x + 1 < matrix.length && matrix[x + 1][y] != 0) {
            if (matrix[x + 1][y] == 2) {
                matrix[x + 1][y] = 0;
                reset(matrix, x + 1, y);
            } else {
                matrix[x + 1][y] = 0;
            }

        }
        if (x - 1 >= 0 && matrix[x - 1][y] != 0) {
            if (matrix[x - 1][y] == 2) {
                matrix[x - 1][y] = 0;
                reset(matrix, x - 1, y);
            } else {
                matrix[x - 1][y] = 0;
            }

        }
        if (y + 1 < matrix.length && matrix[x][y + 1] != 0) {
            if (matrix[x][y + 1] == 2) {
                matrix[x][y + 1] = 0;
                reset(matrix, x, y + 1);
            } else {
                matrix[x][y + 1] = 0;
            }

        }
        if (y - 1 >= 0 && matrix[x][y - 1] != 0) {
            if (matrix[x][y - 1] == 2) {
                matrix[x][y - 1] = 0;
                reset(matrix, x, y - 1);
            } else {
                matrix[x][y - 1] = 0;
            }

        }

        if (x + 1 < matrix.length && y + 1 < matrix.length && matrix[x + 1][y + 1] != 0) {
            if (matrix[x + 1][y + 1] == 2) {
                matrix[x + 1][y + 1] = 0;
                reset(matrix, x + 1, y + 1);
            } else {
                matrix[x + 1][y + 1] = 0;
            }

        }

        if (x - 1 >= 0 && y - 1 >= 0 && matrix[x - 1][y - 1] != 0) {
            if (matrix[x - 1][y - 1] == 2) {
                matrix[x - 1][y - 1] = 0;
                reset(matrix, x - 1, y - 1);
            } else {
                matrix[x - 1][y - 1] = 0;
            }

        }

        if (x + 1 < matrix.length && y - 1 >= 0 && matrix[x + 1][y - 1] != 0) {
            if (matrix[x + 1][y - 1] == 2) {
                matrix[x + 1][y - 1] = 0;
                reset(matrix, x + 1, y - 1);
            } else {
                matrix[x + 1][y - 1] = 0;
            }

        }

        if (x - 1 >= 0 && y + 1 < matrix.length && matrix[x - 1][y + 1] != 0) {
            if (matrix[x - 1][y + 1] == 2) {
                matrix[x - 1][y + 1] = 0;
                reset(matrix, x - 1, y + 1);
            } else {
                matrix[x - 1][y + 1] = 0;
            }

        }

    }

    public static void reset(int[][] matrix, int x, int y) {
        int n = matrix.length;
        Map<Integer, Integer> lamps = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 2) {
                    matrix[i][j] = 0;
                } else {
                    lamps.put(i, j);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : lamps.entrySet()) {
            int a = entry.getKey();
            int b = entry.getValue();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == a || j == b || i + j == a + b || a + j == b + i) {
                        if (matrix[i][j] == 0)
                            matrix[i][j] = 1;
                    }
                }
            }
        }


    }
}

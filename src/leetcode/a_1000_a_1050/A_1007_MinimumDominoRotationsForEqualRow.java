package leetcode.a_1000_a_1050;

public class A_1007_MinimumDominoRotationsForEqualRow {
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 4, 2, 2};
        int[] arr2 = {5, 2, 6, 2, 3, 2};
        System.out.println(minDominoRotations(arr, arr2));
    }

    public static int minDominoRotations(int[] arr, int[] arr2) {
        int a = minDominoRotationsHelper(arr, arr2);
        int b = minDominoRotationsHelper(arr2, arr);
        return Math.min(a, b);
    }

    public static int minDominoRotationsHelper(int[] arr, int[] arr2) {
        int min = Integer.MAX_VALUE;
        int count;
        boolean disable;
        for (int i = 1; i <= 6; i++) {
            count = 0;
            disable = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    continue;
                } else {
                    if (arr2[j] == i) {
                        count++;
                    } else {
                        disable = true;
                        break;
                    }
                }
            }
            if (!disable) {
                min = Math.min(min, count);
            }

        }
        return min == Integer.MAX_VALUE ? -1 : min;

    }
}

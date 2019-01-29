package zzz.test;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int[] arr = {1, 6, 8, 9};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.binarySearch(arr, 5));

    }
}

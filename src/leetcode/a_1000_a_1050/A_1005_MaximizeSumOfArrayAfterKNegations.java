package leetcode.a_1000_a_1050;

import java.util.Arrays;

public class A_1005_MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        int[] arr ={4, 2, 3};
        System.out.println(largestSumAfterKNegations(arr, 1));
    }

    public static int largestSumAfterKNegations(int[] arr, int k) {
        Arrays.sort(arr);
        int i = 0;
        while (i < arr.length && k > 0) {
            if (arr[i] < 0) {
                arr[i] = -arr[i];
                i++;
                k--;
            } else{
                break;
            }

        }
        if (k> 0) {
            if (k % 2 != 0) {
                Arrays.sort(arr);
                arr[0] = -arr[0];
            }
        }
        int sum = 0;
        for(i=0; i< arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }
}

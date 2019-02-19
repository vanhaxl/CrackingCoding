package zzz.test;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {9, 1, 2, 5, 8, 3};
        int[] result = maxArray(nums, 5);
        System.out.println(Arrays.toString(result));
    }

    // use stack is easier to understand, but stack is slower than array ^^
    public static int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];

        for (int i = 0, j = 0; i < n; ++i) {
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) {
                j--;
            }
            if (j < k) ans[j++] = nums[i];
        }
        return ans;
    }


}

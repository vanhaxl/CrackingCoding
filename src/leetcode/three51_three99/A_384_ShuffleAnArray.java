package leetcode.three51_three99;

import java.util.Arrays;
import java.util.Random;

public class A_384_ShuffleAnArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution(nums);

        System.out.println(Arrays.toString(solution.shuffle()));

        System.out.println(Arrays.toString(solution.reset()));
    }
}

class Solution {

    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }


    public int[] reset() {
        return nums;
    }


    public int[] shuffle() {
        int[] res = nums.clone();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = i + random.nextInt(n - i);  // random.nextInt(n): random num from 0 to n-1
            swap(res, i, index);
        }
        return res;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

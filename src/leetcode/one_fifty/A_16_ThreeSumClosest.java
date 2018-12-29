package leetcode.one_fifty;

import java.util.Arrays;

public class A_16_ThreeSumClosest {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 1, -3};
        System.out.println(threeSumClosest(arr, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int minDiff = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < len; i++) {
            int remainForTwo = target - nums[i];
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int tmp = nums[l] + nums[r];
                if (Math.abs(remainForTwo - tmp) < minDiff) {
                    minDiff = Math.abs(remainForTwo - tmp);
                    result = nums[i] + nums[l] + nums[r];
                }
                if (tmp == remainForTwo) {
                    return nums[i] + nums[l] + nums[r];
                } else if (tmp < remainForTwo) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }
}

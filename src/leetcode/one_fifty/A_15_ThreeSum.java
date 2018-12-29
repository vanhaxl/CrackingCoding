package leetcode.one_fifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_15_ThreeSum {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr, 0));
    }

    public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[len - 2] + nums[len - 1] < target) continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] > target) break;
            int remain = target - nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int tmp = nums[l] + nums[r];
                if (tmp < remain) {
                    l++;
                } else if (tmp > remain) {
                    r--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }
        return result;
    }
}

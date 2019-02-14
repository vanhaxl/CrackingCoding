package leetcode.one_fifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_18_FourSum {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(fourSum(arr, -1));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {  //n
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            int remainForThree = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {  //n
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[j] + nums[len - 2] + nums[len - 1] < remainForThree) continue;
                if (nums[j] + nums[j + 1] + nums[j + 2] > remainForThree) break;
                int remainForTwo = remainForThree - nums[j];
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    int tmp = nums[l] + nums[r];
                    if (tmp == remainForTwo) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l--;
                        r--;
                    } else if (tmp < remainForTwo) {
                        l++;
                    } else {
                        r--;
                    }
                }

            }
        }
        return result;

    }
}

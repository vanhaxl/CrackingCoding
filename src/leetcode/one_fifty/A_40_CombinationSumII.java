package leetcode.one_fifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_40_CombinationSumII {
    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(nums, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, tempList, nums, target, 0);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) return;
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // check here to ignore repeat
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, remain - nums[i], i + 1); // start la i+1 as no repeat
            tempList.remove(tempList.size() - 1);
        }
    }
}

/*
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 */

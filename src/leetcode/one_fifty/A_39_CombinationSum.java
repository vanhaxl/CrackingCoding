package leetcode.one_fifty;

import java.util.ArrayList;
import java.util.List;

public class A_39_CombinationSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        System.out.println(combinationSum(nums, 8));
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
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
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, remain - nums[i], i); // start se la i, ko tang no vi no co the lap
            tempList.remove(tempList.size() -1);
        }
    }
}

/*
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */

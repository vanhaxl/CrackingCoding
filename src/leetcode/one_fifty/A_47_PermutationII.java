package leetcode.one_fifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_47_PermutationII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(result, tempList, used, nums);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, boolean[] used, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            tempList.add(nums[i]);
            used[i] = true;
            backtrack(result, tempList, used, nums);
            used[i] = false;
            tempList.remove(tempList.size() - 1);

        }
    }
}

/*
Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */

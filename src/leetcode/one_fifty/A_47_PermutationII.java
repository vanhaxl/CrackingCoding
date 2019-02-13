package leetcode.one_fifty;

import java.util.ArrayList;
import java.util.List;

public class A_47_PermutationII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(result, tempList, nums, 0);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        if (tempList.size() == nums.length) {
            result.add(tempList);
        }
        for (int i = 0; i < nums.length; i++) {

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

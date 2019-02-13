package leetcode.fiftyone_onehundres;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_90_SubsetII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, tempList, nums, 0);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

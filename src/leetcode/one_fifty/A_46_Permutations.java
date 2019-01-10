package leetcode.one_fifty;

import java.util.ArrayList;
import java.util.List;

public class A_46_Permutations {
    public static void main(String[] args){
        int[] nums = {1,2 ,3};
        System.out.println(permute(nums));

        String a = "40000000009902412345600000000000000006279000000000000000000000102077771692000000102105+0000500000        2019009120251000000000000000000000000000000000                         0000000000N                                                        0000000000000000840               005936634                                                                                                                                                                               00000000000000137663497712440125                                                                                                          ";
        System.out.println(a.substring(475, 494));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        return result;
    }

    public static void swap(int[] nums, int i , int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }
}

/*
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

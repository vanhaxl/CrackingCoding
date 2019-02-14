package leetcode.two00_two50;

import java.util.ArrayList;
import java.util.List;

public class A_216_CombinationSumIII {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(result, tempList, k, n, 1);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int k, int remain, int start) {
        if (k < 0 || remain < 0) return;
        if (k == 0 && remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (tempList.contains(i)) continue;
            tempList.add(i);
            backtrack(result, tempList, k - 1, remain - i, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

}

/*
Find all possible combinations of k numbers that add up to a number n,
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]

 */

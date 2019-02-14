package leetcode.fiftyone_onehundres;

import java.util.ArrayList;
import java.util.List;

public class A_77_Combinations {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(result, tempList, n, k, 1);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int n, int k, int start) {
        if(k == 0){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = start; i<= n; i++){
            if(tempList.contains(i)) continue;
            tempList.add(i);
            backtrack(result, tempList, n, k-1, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }
}

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */

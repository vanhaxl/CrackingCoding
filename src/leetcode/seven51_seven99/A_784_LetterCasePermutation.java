package leetcode.seven51_seven99;

import java.util.ArrayList;
import java.util.List;

public class A_784_LetterCasePermutation {
    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println(letterCasePermutation(s));
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, s.toCharArray(), 0);
        return result;
    }

    public static void backtrack(List<String> result, char[] arr, int start) {
        result.add(String.valueOf(arr));
        for (int i = start; i < arr.length; i++) {
            if (Character.isLetter(arr[i])) {
                Character original = arr[i];
                arr[i] = Character.isLowerCase(arr[i]) ? Character.toUpperCase(arr[i]) : Character.toLowerCase(arr[i]);
                backtrack(result, arr, i + 1);
                arr[i] = original;
            }
        }
    }

}

/*
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
 */

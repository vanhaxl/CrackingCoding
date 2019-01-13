package leetcode.one00_one50;

import java.util.ArrayList;
import java.util.List;

public class A_131_PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }

    static List<List<String>> resultList;
    static List<String> curList;

    public static List<List<String>> partition(String s) {
        resultList = new ArrayList<>();
        curList = new ArrayList<>();
        backtrack(s, 0);
        return resultList;
    }

    public static void backtrack(String s, int start) {
        if (curList.size() > 0 && start >= s.length()) {
            resultList.add(new ArrayList<>(curList));
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                if (start == i) {
                    curList.add(Character.toString(s.charAt(i)));
                } else {
                    curList.add(s.substring(start, i + 1));
                }
                backtrack(s, i + 1);
                curList.remove(curList.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            if (a != b) return false;
            i++;
            j--;
        }
        return true;
    }
}

/*
backtracking
 */

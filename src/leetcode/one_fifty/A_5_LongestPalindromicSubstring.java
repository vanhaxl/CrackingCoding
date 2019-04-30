package leetcode.one_fifty;

public class A_5_LongestPalindromicSubstring {
    private static int maxLen = 0;
    private static String result = "";

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        maxLen = 0;
        result = "";
        for (int i = 0; i < s.length(); i++) {
            longestPalindromeHelper(s, i - 1, i + 1);
            longestPalindromeHelper(s, i, i + 1);
        }
        return result;
    }

    public static void longestPalindromeHelper(String s, int left, int right) {

        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if (right - left > maxLen) {
            maxLen = right - left;
            result = s.substring(left + 1, right);
        }
    }
}




/*
Given a string s, find the longest palindromic substring in s.
You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

 */

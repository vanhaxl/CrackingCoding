package leetcode.one_fifty;

public class A_5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int max = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {

            String tmp = longestPalindromeHelper(s, i);
            if (tmp.length() > max) {
                max = tmp.length();
                result = tmp;
            }
            String tmp2 = longestPalindromeHelper2(s, i);
            if (tmp2.length() > max) {
                max = tmp2.length();
                result = tmp2;
            }
        }
        return result;
    }

    public static String longestPalindromeHelper(String s, int i) {
        int len = 1;
        int left = i - 1, right = i + 1;
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            len += 2;
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static String longestPalindromeHelper2(String s, int i) {
        int len = 0;
        int left = i, right = i + 1;
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            len += 2;
            left--;
            right++;
        }
        return s.substring(left + 1, right);
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

package leetcode.three00_three50;

import java.util.Arrays;

public class A_300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}

/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

O(nlogn)
 */

/*
    Use dynamic programming, dp[nums.length]
    dp[0] = 1, because array have 1 element.
    for element i. check all dp[j] in which nums[j] < nums[i]. Find the max one.
    Then plus 1.
    Use the max variable, so we don't need to loop dp array again to find max.
 */

package leetcode.fiftyone_onehundres;

import java.util.Arrays;

public class A_72_EditDistance {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m * n == 0) return m + n;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= m; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int a = dp[i - 1][j];
                    int b = dp[i][j - 1];
                    int c = dp[i - 1][j - 1];
                    dp[i][j] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    dp[i][j]++;
                }
            }
        }
        return dp[m][n];
    }
}

/*
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
 */

/*
horse
h: keep khi giong nhau keep: dp[i][j] = dp[i-1][j-1]
h: del : dp[i][j] = dp[i-1][j] +1
h: insert dp[i][j] = dp[i][j-1] + 1
h: replace dp[i][j] = dp[i-1][j-1] + 1
 */

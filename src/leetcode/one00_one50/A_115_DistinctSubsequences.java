package leetcode.one00_one50;

public class A_115_DistinctSubsequences {
    static int count;

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        System.out.println(numDistinct(s, t));
    }

    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) return 0;
        if (m == n) return s.equals(t) ? 1 : 0;

        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i<=m; i++){
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = s.charAt(i - 1);
                char c2 = t.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];

    }


}

/*
From here we can easily fill the whole grid: for each (x, y),
we check if S[x] == T[y] we add the previous item and the previous item in the previous row,
otherwise we copy the previous item in the same row. The reason is simple:

if the current character in S doesn't equal to current character T,
then we have the same number of distinct subsequences as we had without the new character.
if the current character in S equal to the current character T,
then the distinct number of subsequences: the number we had before plus the distinct number of subsequences
we had with less longer T and less longer S.

m = s.length
n = t.length

dp[i][j]
 */





/*
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by
deleting some (can be none) of the characters without disturbing the relative positions
of the remaining characters.
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
Example 2:

Input: S = "babgbag", T = "bag"
Output: 5
Explanation:

As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^

 */

package leetcode.one_fifty;

public class A_44_WildcardMatching {
    public static void main(String[] args) {
        String s = "a";
        String p = "?";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n && p.charAt(i - 1) == '*'; i++)
            dp[0][i] = true;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}

/* top -> down: string
 * left -> right: pattern
 * dp[0][0]: both are empty --> true
 * + First row: dp[0][j] = true if p starts with *, otherwise false
 * + First Column: dp[i][0] always false as p is empty
 *
 * + dp[i][j] = true if:
 *      - s[i] == p[j] or p[j] == '?' && dp[i - 1][j - 1] = true
 *      - p[j] == '*' and (dp[i-1][j] == true || dp[i][j-1] == true)
 *          + dp[i-1][j]: * acts as empty string
 *          + dp[i][j - 1]: * acts as like any sequences
 */
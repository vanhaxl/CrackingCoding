package leetcode.one_fifty;

public class A_10_RegularExpressionMatching {
    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 2; i <= n && p.charAt(i - 1) == '*'; i += 2) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}


/* top -> down: String
 * left -> right: pattern
 * + dp[0][0] = true as both are empty
 * + dp[0][j] = true if p looks sth like: a*b*...
 *
 * dp[i][j] = true if:
 *      - s[i-1] == p[j-1] || p[j-1] == '.' and dp[i-1][j-1] == true
 *      - p[j-1] == '*' and
 *          + dp[i][j-2] == true (for example: s = "a" and p = "ac*"): c* acts like an empty string
 *          + s[i - 1] == p[j - 2] and dp[i - 1][j] == true: * acts like a sequences
 *          (for example: s = "acccc" and p = "ac*")
 *          + p[j - 2] == '.' and dp[i - 1][j] == true: .* matches any character
 */
package leetcode.a_1000_a_1050;

public class A_1000_MinimumCosttoMergeStones {
    public static void main(String[] args) {
        int[] stones = {3, 5, 1, 2, 6};
        System.out.println(mergeStones(stones, 3));
    }

    public static int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) > 0) return -1;// why not n%k > 0 ma la n-1 % k-1

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + stones[i];

        int[][] dp = new int[n][n];
        for (int m = k; m <= n; ++m)
            for (int i = 0; i + m <= n; ++i) {
                int j = i + m - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int mid = i; mid < j; mid += k - 1)
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j]);
                if ((j - i) % (k - 1) == 0)
                    dp[i][j] += prefix[j + 1] - prefix[i];
            }
        return dp[0][n - 1];
    }

}
/*
bai nay la merge n piles into 1 piles. 1 lan merge phai merge dung k piles
Tim loi giai optimize the cost.

dp[i][j] means the minimum cost needed to merge stones[i] ~ stones[j].
stones[i] ~ stones[j] will merge as much as possible.
Finally (j - i) % (K - 1) + 1 piles will be left.
It's less than K piles and no more merger happens.

Complexity
Time O(N^3/K) Space O(N^2)
 */

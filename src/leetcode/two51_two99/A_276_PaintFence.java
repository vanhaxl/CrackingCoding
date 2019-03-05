package leetcode.two51_two99;

public class A_276_PaintFence {
    public static void main(String[] args) {
        System.out.println(numWays(3, 0));
    }

    public static int numWays(int n, int k) {
        if (n <= 0) return 0;
        int same = 0, notSame = k; // co 1 thang thi same = 0, vi ko co thang nao dang truoc, not same =k
        for (int i = 1; i < n; i++) {
            int temp = same;
            same = notSame; //ok. same se = previous notSame, vi du aab -> aabb: phai same, nen se bang previous notS
            notSame = (temp + notSame) * (k - 1); // notSame , vi du abc -> abcd hoac abb -> abbd
            // bang (previousS + previousNotSame)*(k-1)
        }
        return same + notSame;
    }
}

/*
dp[i][j]: # ways to paint i post with j color
1 row: i = 0: all is 0
1 col: j = 0: all is 0

 */

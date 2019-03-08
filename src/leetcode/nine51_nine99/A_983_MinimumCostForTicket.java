package leetcode.nine51_nine99;

public class A_983_MinimumCostForTicket {

    public static void main(String[] args) {
        int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = {2, 7, 15};
        System.out.println(mincostTickets(days, costs));
    }

    public static int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n];
        dp[0] = costs[0];
        for (int i = 1; i < n; i++) {
            int index1 = i;
            int index2 = i;
            while (index1 > 0 && days[index1] > days[i] - 7 && days[index1 - 1] + 7 > days[i]) {
                index1--;
            }
            while (index2 > 0 && days[index2] > days[i] - 30 && days[index2 - 1] + 30 > days[i]) {
                index2--;
            }
            dp[i] = Math.min(dp[i - 1] + costs[0], Math.min(index1 == 0 ? costs[1] : (dp[index1 - 1] + costs[1]), (index2 == 0 ? costs[2] : dp[index2 - 1] + costs[2])));
        }
        return dp[n - 1];
    }

}

/*
In a country popular for train travel, you have planned some train travelling one year in advance.
The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.

Train tickets are sold in 3 different ways:

a 1-day pass is sold for costs[0] dollars;
a 7-day pass is sold for costs[1] dollars;
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.
For example, if we get a 7-day pass on day 2,
then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.

Return the minimum number of dollars you need to travel every day in the given list of days.

dp[i]: mincost till days[i-1]
result: dp[n];
index nao ma arr[index1] >  arr[i] - 7, arr[index2] > arr[i] - 30
dp[i] = min(dp[i-1] + cost[0], dp[index1-1] + cost[1], dp[index2-1] + cost[2])

Example 1:

Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation:
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total you spent $11 and covered all the days of your travel.
Example 2:

Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
Output: 17
Explanation:
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total you spent $17 and covered all the days of your travel.
 */

package Leetcode.smart;

/**
 * LeetCode0309 最佳买卖股票时机含冷冻期
 */
public class work0309 {
    public static void main(String[] args) {
        work0309 w = new work0309();
        System.out.println(w.maxProfit(1,2,3,0,2));
    }
    public int maxProfit(int... prices) {
        int n = prices.length;
        //动态规划
        int[][] dp = new int[n][3];
        //dp[i][0] : 目前持有一支股票,对应的最大收益
        //dp[i][1] : 没有任何股票,并且处于冷冻期,也就是在第i天卖了
        //dp[i][2] : 不持有任何股票,不处于冷冻期
        dp[0][0] = -prices[0];//第一天买了,减去花费;dp[0][1],dp[0][2]等于0
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);//分为之前是否持有该股票
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]);//前一天是否是冷冻期
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }
}
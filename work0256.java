package Leetcode.smart;


/**
 * leetcode 256. 粉刷房子
 * lintcode 515. 房屋染色
 */
public class work0256 {

    public static void main(String[] args) {
        work0256 w = new work0256();
        int[][] costs = LecoUtil.LecoNewNums(3, 3, 14, 2, 11, 11, 14, 5, 14, 3, 10);
        System.out.println(w.minCost(costs));
    }

    public int minCost(int[][] costs) {
        // write your code here
        int n = costs.length;
        if(n<1) return 0;
        int[][] dp = new int[n][3];
        dp[0] = costs[0];
        for (int i = 1; i < n; i++) {
           dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        return Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
    }
}


package Leetcode.smart;

public class work0122 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 0) return 0;
        int res = 0;
        int buy;
        int sale;
        for (int i = 0; i < prices.length - 1; i++) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            buy = prices[i];
            while (i < prices.length - 1 && prices[i] < prices[i + 1]) {
                i++;
            }
            sale = prices[i];
            res += sale - buy;
        }
        return res;
    }

    public int maxProfit1(int[] prices) { // 动态规划
        int dp1 = 0;// 不持有股票
        int dp2 = -prices[0];// 持有股票
        for (int i = 1; i < prices.length; i++) {
            int dp = dp1;
            dp1 = Math.max(dp, dp2 + prices[i]);
            dp2 = Math.max(dp2, dp1 - prices[i]);
        }
        return dp1;
    }

    public int maxProfit2(int[] prices) { //贪心,收集所有上坡
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            if (prices[i] - prices[i - 1] > 0) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        work0122 w = new work0122();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(w.maxProfit(prices));
    }
}

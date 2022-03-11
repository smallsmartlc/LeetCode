package Leetcode.smart;

/**
 * 0714 买卖股票的最佳时机含手续费
 */

public class work0714 {
    public static void main(String[] args) {
        work0714 w = new work0714();
        System.out.println(w.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }

    public int maxProfit(int[] prices, int fee) {
        int dp1 = -prices[0];//持有
        int dp2 = 0;// 不持有
        for (int i = 1; i < prices.length; i++) {
            int t = dp1;
            dp1 = Math.max(t, dp2 - prices[i]);
            dp2 = Math.max(dp2, t + prices[i] - fee);
        }
        return dp2;
    }

    public int maxProfit2(int[] prices, int fee) {
        // 贪心
        int ans = 0;
        int min = prices[0] + fee;// 如果我们拥有一只股票,买入时的最低价格(含手续费)
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            if (prices[i] + fee < min) { // 如果当前加上手续费更便宜,我们不如就以这个价格购买
                min = prices[i] + fee;
            } else if (prices[i] > min) { // 如果价比最小值高
                ans += prices[i] - min; // 卖掉
                min = prices[i]; // 如果下一天继续上升
            }
        }
        return ans;
    }
}
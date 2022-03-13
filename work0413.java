package Leetcode.smart;

/**
 * 0413 等差数列划分
 */

public class work0413 {
    public static void main(String[] args) {
        work0413 w = new work0413();
        System.out.println(w.numberOfArithmeticSlices(1, 5, 11, 5));
    }

    public int numberOfArithmeticSlices0(int... nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int ans = 0;
        int[] dp = new int[n];
        int d = nums[1] - nums[0];
        for (int i = 2; i < n; i++) {
            dp[i] = nums[i] - nums[i - 1] == d ? dp[i - 1] + 1 : 0;
            d = nums[i] - nums[i - 1];
            ans += dp[i];
        }
        return ans;
    }

    public int numberOfArithmeticSlices(int... nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int ans = 0;
        int dp = 0;
        for (int i = 2; i < n; i++) {
            dp = nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2] ? dp + 1 : 0; //状态转移方程
            ans += dp;
        }
        return ans;
    }
}
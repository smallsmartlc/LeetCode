package Leetcode.smart;

import java.util.Arrays;

/**
 * LeetCode0494 目标和
 */

public class work0494 {
    public static void main(String[] args) {
        work0494 w = new work0494();
        System.out.println(w.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }

    public int findTargetSumWays(int[] nums, int target) {
        // 思路，分为一个正集和一个负集
        // sum(+) sum(-)
        // sum(+) - sum(-) = target
        // sum(+) - sum(-) + sum(+) + sum(-) = target + sum
        // 2sum(+) = target + sum;
        // 转化为求子集的和为 (target + sum) / 2;
        int sum = Arrays.stream(nums).sum();
        if ((target + sum) % 2 != 0) return 0;
        int newTar = (sum + target) / 2;
        if(newTar < 0) return 0; // 不能为负
        int len = nums.length;
        int[][] dp = new int[len][newTar + 1];
        dp[0][0] = 1;
        if (nums[0] < newTar + 1) dp[0][nums[0]] += 1; // 这里+=1防止出现第一个数为0的情况
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= newTar; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][newTar];
    }
}
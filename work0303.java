package Leetcode.smart;

import java.util.Arrays;

/**
 * LeetCode0303 区域和检索 - 数组不可变
 */
public class work0303 {

    public static void main(String[] args) {
        work0303 w = new work0303();
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0, 2));
    }

    private static class NumArray {

        private int[] dp;

        public NumArray(int[] nums) {
            int n = nums.length;
            dp = new int[n];
            if(n < 1) return;
            dp[0] = nums[0];
            for (int i = 1; i < n; i++) {
                dp[i] = dp[i-1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if(i < 1) return dp[j];
            return dp[j] - dp[i-1];
        }
    }

}


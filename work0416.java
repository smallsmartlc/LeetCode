package Leetcode.smart;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * LeetCode0416 分割等和子集
 */

public class work0416 {
    public static void main(String[] args) {
        work0416 w = new work0416();
        System.out.println(w.canPartition(1,5,11,5));
    }

    public boolean canPartition(int... nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        int max = Arrays.stream(nums).max().getAsInt();
        int target = sum /2;
        if(max > target) return false;
        if (sum % 2 != 0) {
            return false;
        }
        // 表示 从（0，i）范围内选取的数是否能使其和为j
        boolean[][] dp = new boolean[n][target+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 0; j <= target; j++) {
                if(j >= num){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-num];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n-1][target];
    }

}
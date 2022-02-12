package Leetcode.smart;


/**
 * LeetCode0377 组合总和 Ⅳ
 */
public class work0377 {
    public static void main(String[] args) {
        work0377 w = new work0377();
        System.out.println(w.combinationSum4(new int[]{1,2,3}, 4));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if(i < num) continue;
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}
package Leetcode.smart;

import java.util.Arrays;

/**
 * LeetCode0245 跳跃游戏 II
 */
public class work0045 {
    public int jump(int[] nums) {
        // 直觉的动态规划,效率一般
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            int max = i + nums[i];
            max = Math.min(len - 1, max);// 不能跳出数组
            for (int j = i + 1; j <= max; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[len-1];
    }

    public int jump2(int[] nums) {
        // 贪心,维护一个最远距离,如果最远距离增加,就增加一次跳的次数
        int len = nums.length;
        int end = 0;// 当前跳跃次数所能到达的最远边界
        int step = 0;// 跳跃次数
        int max = 0;// 下一次能到达的最远距离
        for (int i = 0; i < len - 1; i++) {
            max = Math.max(max,i + nums[i]);
            if(i == end){
                // 当前已经到了当前次数所能到达的最远边界
                end = max;// 跳一次,更新end
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        work0045 w = new work0045();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(w.jump(nums));

    }
}

package Leetcode.smart;

/**
 * 918. 环形子数组的最大和
 */
public class work0918 {
    public int maxSubarraySumCircular(int[] nums) {
        // 分成两种情况讨论,如果结果在中间,就是普通的做法
        // 如果结果在数组两头,那么中间剩下的值就肯定是最小数组和
        int dp1 = nums[0];
        int max = nums[0]; // dp1和max动态规划出最大数组和
        int sum = nums[0]; // 数组的和
        int min = nums[0];
        int dp2 = nums[0];// dp2和min动态规划出最小数组和
        for (int i = 1; i < nums.length; i++) {
            dp1 = dp1 > 0 ? dp1 + nums[i] : nums[i];
            if (dp1 > max) max = dp1;
            dp2 = dp2 < 0 ? dp2 + nums[i] : nums[i];
            if (dp2 < min) min = dp2;
            sum += nums[i];
        }
        if (sum == min) return max; // 说明全为负数,return一个最大的负数
        return Math.max(max, sum - min);
    }

    public static void main(String[] args) {
        work0918 w = new work0918();
//        int[] nums = new int[]{-2, 4, -5, 4, -5, 9, 4};
        int[] nums = new int[]{-3, -2, -3};
        System.out.println(w.maxSubarraySumCircular(nums));
    }
}

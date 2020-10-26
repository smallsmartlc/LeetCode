package Leetcode.smart;


public class work0198 {
    public static void main(String[] args) {
        work0198 w = new work0198();
        int[] nums = {1};
        System.out.println(w.rob(nums));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[dp.length - 1];
    }

    public int rob2(int[] nums) {
        //使用滚动数组来优化
        //只需要存储前两间房屋的最高总金额
        int n = nums.length;
        if (nums == null || n == 0) {
            return 0;
        }
        if (n == 1) return nums[0];

        int dp1 = 0;
        int dp2 = 0;
        for (int i = 0; i < n; i++) {
            int temp = Math.max(dp2, dp1 + nums[i]);
            dp1 = dp2;
            dp2 = temp;
        }
        return dp2;

    }

}
package Leetcode.smart;

public class work0053 {
	public int maxSubArray(int[] nums) {
		int res = nums[0];
		int sum = 0;
		for(int i = 0 ;i<nums.length;i++) {
			if(sum>0) {
				sum+= nums[i];
			}else {
				sum = nums[i];
			}
			res = Math.max(sum, res);
		}
		return res;
    }
	public int maxSubArray2(int[] nums) {
		//尝试使用动态规划
		int len = nums.length;
		int[] dp = new int[len];
		dp[0] = nums[0];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = dp[i-1]>0?dp[i-1]+nums[i]:nums[i];
		}
		int res = dp[0];
		for (int i : dp) {
			if(res<i) res = i;
		}
		return res;
	}
	public static void main(String[] args) {
		work0053 w = new work0053();
		int[] nums = new int[] {-1,2,3};
		System.out.println(w.maxSubArray(nums));
	}
}

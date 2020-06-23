package Leetcode.smart;


/**

 */
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
	public static void main(String[] args) {
		work0053 w = new work0053();
		int[] nums = new int[] {-1,2,3};
		System.out.println(w.maxSubArray(nums));
		
	}
}

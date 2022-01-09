package Leetcode.smart;

/**

 */
public class work0055 {
	public boolean canJump3(int[] nums) {
		//一个一个跳,维护一个最远距离,如果最远距离小于下标,返回false
		int k = 0;
		for(int i = 0;i<nums.length;i++) {
			if(i>k) return false;
			k = Math.max(k, i+nums[i]);
		}
		return true;
	}
	public boolean canJump2(int[] nums) {
		//递归,超时
		jump(nums, 0);
		return res;
    }
	boolean res = false;
	public void jump(int[] nums,int index){
		if(nums[index]+index>=nums.length-1) {
			res = true;
			return;
		} 
		for (int i = 1; i <= nums[index]; i++) {
			jump(nums, index+i);
		}
		return;
	}
	public static void main(String[] args) {
		work0055 w = new work0055();
		int[] nums = new int[]{3,0,8,2,0,0,1};
		System.out.println(w.canJump3(nums));
		
	}
}

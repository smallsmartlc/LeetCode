package Leetcode.smart;

public class work0027 {
	public int removeElement(int[] nums, int val) {
		if(nums.length==0) return 0;
		int i = 0;
		for(int j=0;j<nums.length;j++) {
			if(nums[j]!=val) {
				nums[i]=nums[j];
				i++;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		work0027 w = new work0027();
		int[] nums = { 1, 1, 2, 2, 2, 2, 3, 4, 5 };
		System.out.println(w.removeElement(nums,2));
	}
}

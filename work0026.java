package Leetcode.smart;

public class work0026 {
	public int removeDuplicates(int[] nums) {
		if(nums.length==0) return 0;
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if(nums[i]!=nums[j]) {
				i++;
				nums[i] =nums[j]; 
			}
		}
		return i+1;
	}
	public static void main(String[] args) {
		work0026 w = new work0026();
		int[] nums = {1,1,2,2,2,2,3,4,5} ;
		System.out.println(w.removeDuplicates(nums));
	}
}

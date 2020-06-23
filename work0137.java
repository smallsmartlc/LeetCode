package Leetcode.smart;

import java.util.Arrays;

public class work0137 {
	public int singleNumber(int[] nums) {
		//≈≈–Ú
		Arrays.sort(nums);
		int i = 0;
		while(i<nums.length-1) {
			if(nums[i]!=nums[i+1]) return nums[i];
			i+=3;
		} 
		return nums[i];
	}
	public int singleNumber2(int[] nums) {
		//“ÏªÚ,πÌ≤≈À„∑®
		//a^b^a = a^a^b,a^a = 0,0^b = b;
		int seenOnce = 0, seenTwice = 0;
		for(int i = 0;i<nums.length;i++) {
			seenOnce = ~seenTwice & (seenOnce ^ nums[i]);
		    seenTwice = ~seenOnce & (seenTwice ^ nums[i]);
		}
		return seenOnce;
    }
	public static void main(String[] args) {
		work0137 w = new work0137();
		int[] nums = new int[]{2,2,1,2};
		LecoUtil.LecoPrint(nums);
		System.out.println(w.singleNumber(nums));
		
	}
}

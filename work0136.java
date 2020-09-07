package Leetcode.smart;

import java.util.Arrays;

public class work0136 {
	public void quickSort(int[] nums,int left,int right) {
		if(left>right) return;
		int i=left;
		int j = right;
		int temp = nums[left] ;
		while(i!=j) {
			while(j>i&&nums[j]>=temp) j--;
			nums[i] = nums[j];
			while(i<j&&nums[i]<=temp) i++;
			nums[j] = nums[i];
		}
		nums[j] = temp;
		quickSort(nums, left, i-1);
		quickSort(nums, i+1, right);
	}
	public int singleNumber2(int[] nums) {
		//ÅÅÐò
		Arrays.sort(nums);
		int i = 0;
		while(i<nums.length-1) {
			if(nums[i]!=nums[i+1]) return nums[i];
			i+=2;
		} 
		return nums[i];
	}
	public int singleNumber(int[] nums) {
		//Òì»ò,¹í²ÅËã·¨
		//a^b^a = a^a^b,a^a = 0,0^b = b;
		int res = 0;
		for(int i = 0;i<nums.length;i++) {
			res ^= nums[i] ;
		}
		return res;
    }
	public static void main(String[] args) {
		work0136 w = new work0136();
		int[] nums = new int[]{4,1,2,1,2};
		LecoUtil.LecoPrint(nums);
		System.out.println(w.singleNumber2(nums));
	}
}

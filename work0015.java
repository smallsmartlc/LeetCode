package Leetcode.smart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class work0015 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length <= 2) {
			return res;
		}
		Arrays.sort(nums);
		if(nums[0] > 0 || nums[nums.length - 1] < 0) { return Collections.emptyList();}
		List<Integer> list =null;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>0) break;
			if(i > 0 && nums[i] == nums[i-1]) continue; 
			int left = 	i+1;
			int right = nums.length-1;
			while(left<right) {
				int sum = nums[i]+nums[left]+nums[right];
				if(sum==0) {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					while (left < right && nums[left] == nums[left + 1])left++; // 去重
					while (left < right && nums[right] == nums[right - 1])right--; // 去重
					left++;
					right--;
				}
				else if (sum < 0) left++;
	            else if (sum > 0) right--;
			}
		}
		return res;
    }
	public static void main(String[] args) {
		work0015 w = new work0015();
		int[] nums = {1,-1,-1,0};
		System.out.println(w.threeSum(nums));
	}
}

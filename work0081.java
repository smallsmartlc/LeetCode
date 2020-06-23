package Leetcode.smart;

public class work0081 {
	public boolean search(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		int mid = 0;
		while(left<=right) {
			mid = (left+right)/2;
			if(nums[mid]==target) return true;
			if(nums[left]==nums[mid]) {
				left++;
				continue;
			}
			if(nums[left]<nums[mid]) {
				//或者退化为顺序查找,直接遍历
				if(nums[left]<=target&&nums[mid]>=target) {
					right = mid -1 ;
				}else {
					left = mid +1;
				}
			}else {
				if(nums[right]>=target&&nums[mid]<=target) {
					left = mid +1 ;
				}else {
					right = mid -1;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		work0081 w = new work0081();
		int[] nums = new int[]{1,3,1,1,1};
		System.out.println(w.search(nums,3));
		
	}
}

package Leetcode.smart;


public class work0033 {
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		int mid = 0;
		while(left<=right) {
			mid = (left+right)/2;
			if(nums[mid]==target) return mid;
			if(nums[left]<=nums[mid]) {
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
		return -1;
	}
	public static void main(String[] args) {
		work0033 w = new work0033();
		int[] nums = new int[]{5,1,3};
		System.out.println(w.search(nums,3));
		
	}
}

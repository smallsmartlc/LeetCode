package Leetcode.smart;

public class work0035 {
	public int searchInsert(int[] nums, int target) {
		for(int i =0 ;i<nums.length;i++) {
			if(nums[i]>=target)return i;
		}
		return nums.length;
    }
	public int binarySearchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while(left <= right) {
			int mid = (right + left)/2;
			if(nums[mid] == target) {return mid;}
			if(nums[mid]< target) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return left;
	}
	public static void main(String[] args) {
		work0035 w = new work0035();
		int[] nums = new int[]{1,3,5,6};
		System.out.println(w.binarySearchInsert(nums, 7));
	}
}

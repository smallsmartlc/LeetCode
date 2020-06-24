package Leetcode.smart;

public class work0162 {
	public static void main(String[] args) {
		work0162 w = new work0162();
		int[] nums = new int[] {1,2,3,1};
		System.out.println(w.findPeakElement(nums));
	}
	//要求,时间复杂度O(logn)
	public int findPeakElement(int[] nums) {
		//二分法,递归
		return search(nums, 0, nums.length-1);
    }
	public int search(int[] nums , int left , int right) {
		if(left == right) return left;
		int mid = (left + right) / 2;
		if (nums[mid] > nums[mid + 1]) {
			return search(nums, left, mid);
		}
		return search(nums, mid+1, right);
	}
}


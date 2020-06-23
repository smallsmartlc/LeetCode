package Leetcode.smart;

 
public class work0153 {
	public int search(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		int mid = 0;
		int min = Integer.MAX_VALUE;
		while(left<=right) {
			if(nums[left]<=nums[right]) return nums[left];
			mid = (left+right)/2;
			if(nums[left]<=nums[mid]) {
				left = mid+1;
			}else {
				left++;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		work0153 w = new work0153();
		int[] nums = new int[]{3,4,5,1,2};
		System.out.println(w.search(nums));
		
	}
}

package Leetcode.smart;


public class work0034 {
	public int[] searchRange(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		int mid = 0;
		int first;
		int end;
		while(left<=right) {
			mid = (left+right)/2;
			if(nums[mid]==target) {
				first = mid;
				end = mid;
				while(first-1>=0&&nums[first-1]==target) {
					first--;
				}
				while(end+1<nums.length&&nums[end+1]==target) {
					end++;
				}
				return new int[]{first,end};
			}
			if(nums[mid]>=target) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		
		return new int[]{-1,-1};
    }
	public static void main(String[] args) {
		work0034 w = new work0034();
		int[] nums = new int[]{2,2};
		int[] res = w.searchRange(nums,2);
		for (int i : res) {
			System.out.print(i+",");
		}
	}
}

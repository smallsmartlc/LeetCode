package Leetcode.smart;

 
public class work0154 {
		public int search(int[] nums) {
			int left = 0;
			int right = nums.length-1;
			int mid = 0;
			while(left<=right) {
				if(nums[left]<nums[right]|| left == right) return nums[left];
				mid = (left+right)/2;// 二分法找中点
				if(nums[left]<nums[mid]) {
					left = mid+1;
				}else if (nums[left] == nums[mid]) {
					//无法判断数组的情况,直接顺序查找
					left++;
				}else {
					right = mid;
				}
			}
			return -1;
		}
	public static void main(String[] args) {
		work0154 w = new work0154();
		int[] nums = new int[]{3,1,3};
		System.out.println(w.search(nums));
		
	}
}

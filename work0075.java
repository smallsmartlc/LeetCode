package Leetcode.smart;


public class work0075 {
	public void sortColors(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int cur = 0;
		while (cur <= right) {
			if (nums[cur] < 1) {
				int temp = nums[cur];
				nums[cur] = nums[left];
				nums[left] = temp;
				cur++;
				left++;
			} else if (nums[cur] > 1) {
				int temp = nums[cur];
				nums[cur] = nums[right];
				nums[right] = temp;
				right--;
			} else {
				cur++;
			}
		}
	}

	public static void main(String[] args) {
		work0075 w = new work0075();
		int[] nums = new int[] { 2, 0, 2, 1, 1, 0 };
//		int[] nums = new int[] {1,2,0};
		w.sortColors(nums);
		LecoUtil.LecoPrint(nums);
	}
}

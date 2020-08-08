package Leetcode.smart;

public class work0080 {
	public int removeDuplicates(int[] nums) {
		//双指针之同向指针
		if (nums.length < 3) return nums.length;
		int low = 0;
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				count++;
			} else {
				count = 1;
			}
			if (count < 3) {
				nums[low] = nums[i];
				low++;
			}
		}
		return low;
	}
	public int removeDuplicates2(int[] nums) {
		if (nums.length<3) return nums.length;
		int len = nums.length;
		for (int i = 2; i < len;i++) {
			if(nums[i] == nums[i-1]&&nums[i-1] == nums[i-2]) {
				for (int j = i; j < len-1; j++) {
					nums[j] = nums[j+1];
				}
				i--;
				len--;
			}
		}
		return len;
    }
	public static void main(String[] args) {
		work0080 w= new work0080();
		int[] nums = new int[] {0,0,1,1,1,1,2,3,3};
		System.out.println(w.removeDuplicates(nums));
		LecoUtil.LecoPrint(nums);
	}
}

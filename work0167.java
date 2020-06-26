package Leetcode.smart;


public class work0167 {
	public static void main(String[] args) {
		work0167 w = new work0167();
		int[] nums = {2, 7, 11, 15};
		System.out.println(w.twoSum(nums, 9));
	}
	public int[] twoSum(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length-1;
		while (left<right) {
			int sum = numbers[left]+numbers[right];
			if(sum==target) return new int[]{left+1,right+1};
			if(sum<target) left++;
			else right--;
		}
		return new int[] {-1,-1};
    }
}


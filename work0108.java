package Leetcode.smart;


public class work0108 {
	public static void main(String[] args) {
		work0108 w= new work0108();
		int[] nums = new int[] {-10,-3,0,5,9};
		TreeNode dif = w.sortedArrayToBST(nums);
		System.out.println();
	}
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length<1) return null;
		return dif(nums, 0, nums.length-1);
    }
	public TreeNode dif(int[] nums ,int start,int end) {
		int root = (start+end)/2;
		TreeNode res = new TreeNode(nums[root]);
		if(start<root) {
			res.left = dif(nums, start, root-1);
		}
		if (root<end) {
			res.right = dif(nums, root+1, end);
		}
		return res;
	}	
}

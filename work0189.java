package Leetcode.smart;

import java.util.Arrays;

public class work0189{
	public static void main(String[] args) {
		work0189 w = new work0189();
		int[] nums = {1,2,3,4,5,6,7};
//		int[] nums = {-1};
		System.out.println(Arrays.toString(nums));
		w.rotate3(nums, 2);
		System.out.println(Arrays.toString(nums));
	}
    public void rotate1(int[] nums, int k) {
    	if(k>nums.length) k = k%nums.length;//优化
    	//旋转k次
    	int temp;
    	for (int i = 0; i < k; i++) {
			int pre = nums[nums.length-1];
			for (int j = 0; j < nums.length; j++) {
				temp = nums[j];
				nums[j] = pre;
				pre = temp;
			}
		}
    }
    public void rotate2(int[] nums, int k) {
    	if(k>nums.length) k = k%nums.length;
    	reverse(nums, 0, nums.length);
    	reverse(nums, 0, k);
    	reverse(nums, k, nums.length-k);
    }
    public void reverse(int[] nums,int start,int len) {
    	for (int i = 0; i < len/2; i++) {
			int temp = nums[start+i];
			nums[start+i] = nums[start+len-1-i];
			nums[start+len-1-i] = temp;
		}
    }
    public void rotate3(int[] nums, int k) {
    	int len  = nums.length;
    	k = k % len;
    	int count = 0;         // 记录交换位置的次数，n个同学一共需要换n次
    	for(int start = 0; count < len; start++) {
    		int cur = start;       // 从0位置开始换位子
    		int pre = nums[cur];   
    		do{
    			int next = (cur + k) % len;
    			int temp = nums[next];    // 来到角落...
    			nums[next] = pre;
    			pre = temp;
    			cur = next;
    			count++;
    		}while(start != cur)  ;     // 循环暂停，回到起始位置，角落无人
    	} 
    }
}
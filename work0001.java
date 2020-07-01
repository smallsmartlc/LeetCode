package Leetcode.smart;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class work0001 {
	public int[] twoSum(int[] nums, int target) {
    	Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
        	map.put(nums[i], i);
        }
        for(int i = 0;i<nums.length;i++) {
        	int com = target-nums[i];
        	if (map.containsKey(com)&&map.get(com)!=i) {
        		 return new int[] { i, map.get(com)};
			}
        }
        throw new IllegalArgumentException("No two sum solution");
    }
	
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int com = target-nums[i];
			if(map.containsKey(com)) return new int[]{map.get(com),i};
			map.put(nums[i], i);
		}
		return new int[] {};
	}
	public static void main(String[] args) {
		work0001 w = new work0001();
		int[] nums = {2,7,11,15};
		System.out.println(Arrays.toString(w.twoSum2(nums, 9)));
	}
}

package Leetcode.smart;

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
}

package Leetcode.smart;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class work0169 {
	public static void main(String[] args) {
		work0169 w = new work0169();
		int[] nums = {3,2,3};
		System.out.println(w.majorityElement(nums));
	}
    public int majorityElement0(int[] nums) {
    	//¹şÏ£±í·¨
    	Map<Integer, Integer> map = new HashMap<>();
    	for (int i : nums) {
			if(!map.containsKey(i)) {
				map.put(i, 1);
			}else {
				map.put(i, map.get(i)+1);
			}
			if(map.get(i)>nums.length/2) return i;
		}
    	return -1;
    }
    public int majorityElement(int[] nums) {
    	//ÅÅĞò·¨
    	Arrays.sort(nums);
    	return nums[nums.length/2];
    }
}


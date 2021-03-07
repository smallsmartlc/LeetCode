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
    	//哈希表法
    	Map<Integer, Integer> map = new HashMap<>();
    	for (int i : nums) {
    		map.putIfAbsent(i,0);
			map.put(i, map.get(i)+1);
			if(map.get(i)>nums.length/2) return i;
		}
    	return -1;
    }
    public int majorityElement1(int[] nums) {
    	//排序法
    	Arrays.sort(nums);
    	return nums[nums.length/2];
    }
	public int majorityElement(int[] nums){
		// 摩尔排序
		int res = nums[0];
		int count = 0;
		for (int num : nums) {
			if(res == num){
				count++;
				continue;
			}
			if(count == 0){
				res = num;
				count++;
				continue;
			}
			count--;
		}
		count = 0;
		for (int num : nums) {
			if(res == num) count++;
			if(count > nums.length/2) return res;
		}
		return -1;
	}
}


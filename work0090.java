package Leetcode.smart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class work0090 {
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		res.add(new ArrayList<>());
		find(new ArrayList<>(), 0, nums);
		return res;
	}
	private void find(List<Integer> list,int index,int[] nums) {
		if(index == nums.length) {
			return;
		}
		for(int i = index ; i < nums.length ; i++) {
			if(i>index&&nums[i]==nums[i-1]) continue;//Í¬²ãÖØ¸´£¬Ìø¹ı
			list.add(nums[i]);
			find(list, i+1, nums);
			res.add(new ArrayList<>(list));
			list.remove(list.size()-1);
		}
	}
	public static void main(String[] args) {
		work0090 w= new work0090();
		int[] nums = new int[] {1,2,2};
		System.out.println(w.subsetsWithDup(nums));
	}
}

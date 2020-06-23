package Leetcode.smart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class work0090 {
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		find(0, nums, new ArrayList<>());
		return res;
    }
	public void find(int index,int[] nums,List<Integer> list) {
		if(!res.contains(list)) {
			res.add(new ArrayList<>(list));
		}
		if (list.size()==nums.length) {
			return;
		}
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			find(i+1, nums, list);
			list.remove(list.size()-1);
		}
	}
	public static void main(String[] args) {
		work0090 w= new work0090();
		int[] nums = new int[] {1,2,2};
		System.out.println(w.subsetsWithDup(nums));
	}
}

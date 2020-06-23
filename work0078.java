package Leetcode.smart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class work0078 {
	public List<List<Integer>> subsets(int[] nums) {
		find(nums, 0, new ArrayList<>());
		return res;
    }
	
	List<List<Integer>> res = new LinkedList<>();
	private void find(int[] nums,int index,List<Integer> list) {
		res.add(new ArrayList<>(list));
		if (list.size()==nums.length) return;
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			find(nums, i+1, list);
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String[] args) {
		work0078 w= new work0078();
		System.out.println(w.subsets(new int[] {1,2,3,4}));
	}
}

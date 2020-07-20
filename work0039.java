package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

public class work0039 {
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates == null || candidates.length == 0 || target < 0) {
			return res;
		}
		List<Integer> list = new ArrayList<>();
		process(0, candidates, target, list);
		return res;
	}

	public void process(int start, int[] candidates, int target, List<Integer> list) {
		if (target < 0) return;
		if (target == 0) res.add(new ArrayList<>(list));
		else {
			for (int i = start; i < candidates.length; i++) {
				list.add(candidates[i]);
				process(i, candidates, target - candidates[i], list);
				list.remove(list.size() - 1);
			}
		}
	}
	public static void main(String[] args) {
		work0039 w = new work0039();
		int[] nums = new int[] { 2, 3, 6, 7 };
		System.out.println(w.combinationSum(nums, 7));
	}
}

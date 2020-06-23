package Leetcode.smart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class work0040 {
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<Integer> list = new ArrayList<>();
		Arrays.sort(candidates);
		process(0, candidates, target, list);
		return res;
    }
	public void process(int start,int[] candidates,int target,List<Integer> list) {
		if(target<0) return ;
		if(target==0) res.add(new ArrayList<>(list));
		else {
			for(int i = start ; i < candidates.length ; i++ ) {
				if(i>start&&candidates[i]==candidates[i-1]) continue;
				list.add(candidates[i]);
				process(i+1, candidates, target-candidates[i], list);
				list.remove(list.size()-1);
			}
		}
	}
	public static void main(String[] args) {
		work0040 w = new work0040();
		int[] nums = new int[] {10,1,2,7,6,1,5};
		System.out.println(w.combinationSum2(nums, 8));
	}
}

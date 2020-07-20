package Leetcode.smart;
/**
 * result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择

作者：labuladong
链接：https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-xiang-jie-by-labuladong-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class work0047 {
	List<List<Integer>> res = new ArrayList<>();
	public void process(int[] nums,List<Integer> list,Set<Integer> idx) {
		if(list.size()>=nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		for(int i=0;i<nums.length;i++) {
			if(idx.contains(i)) continue;
			if(i>0 &&idx.contains(i-1)&& nums[i] == nums[i-1]) continue;
			idx.add(i);
			list.add(nums[i]);
			process(nums, list,idx);
			list.remove(list.size() - 1);
			idx.remove(i);
		}
	} 
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<Integer> list = new ArrayList<>();
		Set<Integer> idx = new HashSet<>();
		process(nums, list, idx);
		return res;
	}
	public static void main(String[] args) {
		work0047 w = new work0047();
		int[] nums = new int[] {1,1,2};
		System.out.println(w.permuteUnique(nums));
	}
}

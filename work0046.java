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
import java.util.List;

public class work0046 {
	List<List<Integer>> res = new ArrayList<>();
	public void process(int index,int[] nums,List<Integer> list) {
		if(list.size()>=nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		for(int i=0;i<nums.length;i++) {
			if(list.contains(nums[i])) continue;
			list.add(nums[i]);
			process(i+1, nums, list);
			list.remove(list.size() - 1);
		}
	}
	public List<List<Integer>> permute(int[] nums) {
		List<Integer> list = new ArrayList<>();
		process(0, nums, list);
		return res;

	}
	public static void main(String[] args) {
		work0046 w = new work0046();
		int[] nums = new int[] {1,2,3};
		System.out.println(w.permute(nums));
	}
}

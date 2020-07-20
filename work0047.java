package Leetcode.smart;
/**
 * result = []
def backtrack(·��, ѡ���б�):
    if �����������:
        result.add(·��)
        return
    
    for ѡ�� in ѡ���б�:
        ��ѡ��
        backtrack(·��, ѡ���б�)
        ����ѡ��

���ߣ�labuladong
���ӣ�https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-xiang-jie-by-labuladong-2/
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
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

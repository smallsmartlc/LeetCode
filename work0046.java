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

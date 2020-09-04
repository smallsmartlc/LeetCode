package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

public class work0113 {

	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<Integer> list = new ArrayList<>();
		dif(root, sum, list);
		return res;
    }
	public void dif(TreeNode root, int sum,List<Integer> list) {
		if(root==null) return;
		list.add(root.val);
		if(root.left==null&&root.right==null&&sum == root.val) {
			res.add(new ArrayList<>(list));
		}
		dif(root.left, sum-root.val, list);
		dif(root.right, sum-root.val, list);
		list.remove(list.size()-1);
	}
	public static void main(String[] args) {
		work0113 w= new work0113();
		TreeNode p = TreeNode.treeNode(5,4,8,11,null,13,4,7,2,null,null,null,null,5,1);
		System.out.println(w.pathSum(p, 22));
	}
}

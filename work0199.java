package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

public class work0199{
	public static void main(String[] args) {
		work0199 w = new work0199();
		TreeNode root = TreeNode.treeNode(1,2,3,null,5,null,4);
		System.out.println(w.rightSideView(root));
	}
	List<Integer> list = new ArrayList<>();
	public List<Integer> rightSideView(TreeNode root) {
		dfs(root,0);
		return list;
    }
	private void dfs(TreeNode root, int depth) {
		if(root == null) return;
		if(depth>=list.size()) { //当该深度第一次出现,加入列表中
			list.add(root.val);
		}
		depth++;
		dfs(root.right, depth);
		dfs(root.left, depth);
	}
}
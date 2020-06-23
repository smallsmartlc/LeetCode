package Leetcode.smart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class work0107 {
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		if (root!=null) {
			q.add(root);
		}
		while(!q.isEmpty()) {
			int n = q.size();
			List<Integer> list = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				TreeNode cur = q.poll();
				list.add(cur.val);	
				if(cur.left!=null) {
					q.add(cur.left);
				}
				if(cur.right!=null) {
					q.add(cur.right);
				}
			}
			res.add(0, list);
		}
		return res;
    }
	public static void main(String[] args) {
		work0107 w= new work0107();
		TreeNode p = TreeNode.treeNode(1,2,null,3,4,null,null,4,3);
		System.out.println(w.levelOrderBottom(p));
	}
}

package Leetcode.smart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class work0103 {
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		if (root!=null) {
			q.add(root);
		}
		boolean is_order_left = true;
		while(!q.isEmpty()) {
			int n = q.size();
			LinkedList<Integer> list = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				TreeNode cur = q.poll();
				if (is_order_left) {
					list.add(cur.val);	
				}else {
					list.addFirst(cur.val);	
				}
				if(cur.left!=null) {
					q.add(cur.left);
				}
				if(cur.right!=null) {
					q.add(cur.right);
				}
			}
			res.add(list);
			is_order_left = !is_order_left;
		}
		return res;
    }
	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		if (root!=null) {
			q.add(root);
		}
		boolean is_order_left = true;
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
			if(is_order_left) {
				res.add(list);
			}else {
				Collections.reverse(list);
				res.add(list);
			}
			is_order_left = !is_order_left;
		}
		return res;
    }
	public static void main(String[] args) {
		work0103 w= new work0103();
		TreeNode p = TreeNode.treeNode(3,9,20,null,null,15,7);
		System.out.println(w.zigzagLevelOrder(p));
	}
}

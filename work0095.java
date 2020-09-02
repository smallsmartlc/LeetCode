package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

public class work0095 {
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> ans = new ArrayList<TreeNode>();
	    if (n == 0) {
	        return ans;
	    }
	    return dif(1, n);
    }
	public List<TreeNode> dif(int start,int end){
		List<TreeNode> res = new ArrayList<>();
		if(start>end) {
			res.add(null);
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> lefts = dif(start, i-1);
			List<TreeNode> rights = dif(i+1, end);
			for (TreeNode l : lefts) {
				for (TreeNode r : rights) {
					TreeNode cur = new TreeNode(i);
					cur.left = l;
					cur.right = r;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		work0095 w = new work0095();
		w.generateTrees(3);
	}
}

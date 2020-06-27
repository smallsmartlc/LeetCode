package Leetcode.smart;

import java.util.LinkedList;
import java.util.Queue;

public class work0173 {
	public static void main(String[] args) {
		work0173 w = new work0173();
		TreeNode root = TreeNode.treeNode(null,null);
		BSTIterator iterator = new BSTIterator(root);
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
	}
    
}
//二叉搜索树的中序序列为升序
class BSTIterator {
	Queue<TreeNode> queue = new LinkedList<>();
    public BSTIterator(TreeNode root) {
    	init(root);
    }
    
    public void init(TreeNode root) {
    	if(root==null) return;
    	if(root.left!=null) init(root.left);
    	queue.add(root);
    	if(root.right!=null) init(root.right);
    }
    
    /** @return the next smallest number */
    public int next() { 
    	return queue.poll().val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return !queue.isEmpty();
    }
}

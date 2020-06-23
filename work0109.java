package Leetcode.smart;


public class work0109 {
	public static void main(String[] args) {
		work0109 w= new work0109();
		ListNode nums = new ListNode(-10,3,0,5,9);
		TreeNode dif = w.sortedListToBST(nums);
		System.out.println();
	}
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null) return null;
		ListNode pre = null;
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null&&fast.next!=null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode res = new TreeNode(slow.val);
		if(pre!=null) {
			pre.next = null;
			res.left = sortedListToBST(head);
		} 
		res.right = sortedListToBST(slow.next);
		return res;
    }
}

package Leetcode.smart;


public class work0148 {
	public static void main(String[] args) {
		 work0148 w = new work0148();
		 ListNode head = new ListNode(-1,0,3,4,5);
		 System.out.println(head);
		 System.out.println(w.sortList(head));
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
	    return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast!=null&&fast.next!=null) {
			slow = slow.next;
			fast = fast.next;
		}
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode cur = new ListNode();
        ListNode res = cur;
        while (left!=null && right!=null) {
			if(left.val < right.val) {
				cur.next = left;
				left = left.next;
			}else {
				cur.next = right;
				right = right.next;
			}
			cur = cur.next;
		}
        cur.next = left!=null?left:right;
        return res.next;
    }
}
package Leetcode.smart;


public class work0086 {
	public ListNode partition(ListNode head, int x) {
		ListNode real = new ListNode();
		real.next = head;
		ListNode small = real;
		ListNode now = real;
		while (now.next != null) {
			ListNode pre = now;
			now = now.next;
			if (now.val < x) {
				ListNode temp = now;
				pre.next = temp.next;
				temp.next = small.next;
				small.next = temp;
				small = temp;
			}
		}
		return real.next;
	}
	public static void main(String[] args) {
		work0086 w= new work0086();
		ListNode head = new ListNode(1,4,3,2,5,2);
//		System.out.println(head);
		System.out.println(w.partition(head,3));
	}
}

package Leetcode.smart;


public class work0083 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode realHead = new ListNode(0);
		realHead.next = head;
		ListNode now = realHead.next;
		while (now != null && now.next != null) {
			while (now.next != null && now.val == now.next.val) {
				now.next = now.next.next;
			}
			now = now.next;
		}
		return realHead.next;
	}
	public static void main(String[] args) {
		work0083 w= new work0083();
		ListNode head = new ListNode(1,1,2,3,3);
		System.out.println(w.deleteDuplicates(head));
	}
}

package Leetcode.smart;


/**

 */
public class work0061 {
	public static void main(String[] args) {
		work0061 w = new work0061();
		ListNode head = new ListNode(1,2,3,4,5);
		System.out.println(head);
		System.out.println(w.rotateRight(head, 2));
	}
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) return null;
		if (head.next == null) return head;
		ListNode now = head;
		int n;
		for (n = 1; now.next != null; n++) {
			now = now.next;
		}
		now.next = head;
		for (int i = 0; i < n-k%n-1; i++) {
			head = head.next;
		}
		ListNode res = head.next;
		head.next = null;
		return res;
	}
}

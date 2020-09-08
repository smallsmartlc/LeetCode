package Leetcode.smart;

public class work0147 {
	public static void main(String[] args) {
		 work0147 w = new work0147();
		 ListNode head = new ListNode(4,2,1,3);
		 System.out.println(head);
		 System.out.println(w.insertionSortList(head));
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode realhead = new ListNode();
		realhead.next = head;
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.val > cur.next.val) {
				ListNode newIndex = head;
				ListNode newPre = realhead;
				while (newIndex.val < cur.next.val) {
					newIndex = newIndex.next;
					newPre = newPre.next;
				}
				ListNode temp = cur.next;
				cur.next = cur.next.next;
				newPre.next = temp;
				temp.next = newIndex;
				head = realhead.next;
			} else {
				cur = cur.next;
			}
		}
		return realhead.next;
	}
}
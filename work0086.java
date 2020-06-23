package Leetcode.smart;


public class work0086 {
	public ListNode partition(ListNode head, int x) {
		if(head==null||head.next==null) return head;
		ListNode realHead = new ListNode(0);
		realHead.next = head;
		ListNode small = realHead;
		ListNode now = realHead;
		while(now.next!=null) {
			ListNode pre = now;
			now = now.next;
			if(now.val<x) {
				ListNode temp = now;
				pre.next = now.next;
				temp.next = small.next;
				small.next = temp;
				small = temp;
			}
		}
		return realHead.next;
    }
	public static void main(String[] args) {
		work0086 w= new work0086();
		ListNode head = new ListNode(1,4,3,2,5,2);
//		System.out.println(head);
		System.out.println(w.partition(head,3));
	}
}

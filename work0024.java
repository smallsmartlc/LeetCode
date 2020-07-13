package Leetcode.smart;


public class work0024 {
	public ListNode swapPairs(ListNode head) {
		if(head==null||head.next == null) return head;
		ListNode firstNode = head;
		ListNode secondNode = head.next;
		firstNode.next = swapPairs(secondNode.next);
		secondNode.next = firstNode;
		return secondNode;
	}
	
	
	public static void main(String[] args) {
		work0024 w = new work0024();
		ListNode head = new ListNode(1, 2, 3, 4, 5);
		System.out.println(w.swapPairs(head));
	}
}

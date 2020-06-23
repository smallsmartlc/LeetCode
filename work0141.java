package Leetcode.smart;

public class work0141 {
	public boolean hasCycle(ListNode head) {
		if(head==null||head.next==null) return false;
        ListNode fast = head.next;
        ListNode low = head;
        while(fast!=low) {
        	if(fast==null||fast.next==null) return false;
        	low = low.next;
        	fast = fast.next.next;
        }
        return true;
    }
	public static void main(String[] args) {
		work0141 w = new work0141();
 		ListNode head = new ListNode(3,2,0,-4);
 		ListNode cur = head;
 		
 		while(cur.next!=null) {
 			cur = cur.next;
 		}
 		cur.next = head.next;
 		System.out.println(w.hasCycle(head));
	}
}

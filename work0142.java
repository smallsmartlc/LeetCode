package Leetcode.smart;

public class work0142 {
	public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        while(fast!=null&&fast.next!=null) {
        	low = low.next;
        	fast = fast.next.next;
        	if(low == fast) {
        		low = head;
        		while (low!=fast) {
					low = low.next;
					fast = fast.next;
				}
        		return fast;
        	}
        }
        return null;
    }
	public static void main(String[] args) {
		work0142 w = new work0142();
 		ListNode head = new ListNode(3,2,0,-4);
 		ListNode cur = head;
 		
 		while(cur.next!=null) {
 			cur = cur.next;
 		}
 		cur.next = head.next;
 		System.out.println(w.detectCycle(head));
	}
}

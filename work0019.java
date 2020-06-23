package Leetcode.smart;

public class work0019 {
	public ListNode removeNthFromEnd1(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
   	 	dummy.next = head;
   	 	ListNode cursor1 = dummy;
   	 	ListNode cursor2 = dummy;
   	 	for(int i=0;i<n;i++) {
   	 		cursor1 = cursor1.next;
   	 	}
   	 	while(cursor1.next!=null) {
   	 		cursor1 = cursor1.next;
   	 		cursor2 = cursor2.next;
   	 	}
   	 	cursor2.next = cursor2.next.next;
		return dummy.next;
	}
	    public ListNode removeNthFromEnd2(ListNode head, int n) {
	    	 ListNode dummy = new ListNode(0);
	    	 dummy.next = head;
	    	ListNode cursor = dummy;
	    	int length = 0;
	    	while(cursor!=null) {
	    		cursor=cursor.next;
	    		length++;
	    	}
	    	cursor = dummy;
	    	for(int i=0;i<length-n-1;i++) {
	    		cursor = cursor.next;
	    	}
	    	System.out.println(cursor);
	    	cursor.next = cursor.next.next;
			return dummy.next;

	}	
	    int cur = 0;
	    public ListNode removeNthFromEnd3(ListNode head, int n) {
			if(head==null) return null;
			head.next = this.removeNthFromEnd3(head.next, n);
			cur++;
			if(cur==n) return head.next;
			
			return head;
		}
	public static void main(String[] args) {
		work0019 w = new work0019();
		ListNode n1 = new ListNode(1);
		n1.next =  new ListNode(2);
		n1.next.next = new ListNode(3);
		n1.next.next.next = new ListNode(4);
		n1.next.next.next.next = new ListNode(5);
		System.out.println(n1);
		ListNode n2 = w.removeNthFromEnd3(n1, 2);
		System.out.println(n2);
	}
}

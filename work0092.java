package Leetcode.smart;


public class work0092 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(m==n) return head;
		ListNode realHead = new ListNode(0);
		realHead.next = head;
		int deep = 0;
		ListNode now = realHead;
		ListNode rev = null;
		ListNode revend = null;
		while(now.next!=null) {
			deep++;
			if(deep>=m&&deep<n) {
				ListNode temp = now.next;
				now.next = now.next.next;
				if(rev == null) {
					rev = temp;
					revend = temp;
				}else {
					temp.next = rev;
					rev = temp;
				}
			}else if(deep==n) {
				ListNode temp = now.next.next;
				now.next.next = rev;
				revend.next = temp;
				break;
			}else {
				now = now.next;
			}
		}
		return realHead.next;
    }
	public static void main(String[] args) {
		work0092 w= new work0092();
		ListNode head = new ListNode(1,2,3,4,5);
		
		System.out.println(w.reverseBetween(head, 2, 4));
	}
}

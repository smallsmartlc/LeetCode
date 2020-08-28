package Leetcode.smart;


public class work0092 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(m==n) return head;
		ListNode realHead = new ListNode(0);
		realHead.next = head;
		ListNode cur = realHead;
		int deep = 0;
		ListNode rev = null;//反转头
		ListNode revend = null;//反转尾
		while(cur.next!=null) {
			deep ++ ;
			if(deep >= m && deep < n) {
				ListNode temp = cur.next;
				cur.next = cur.next.next;
				if(rev == null) {
					rev = temp;
					revend = rev;
				}else {
					temp.next = rev;
					rev = temp;
				}
			}else if (deep == n){
				ListNode temp = cur.next.next;
				cur.next.next = rev;
				revend.next = temp;
				break;
			}else {
				cur = cur.next;
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

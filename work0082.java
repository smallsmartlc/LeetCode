package Leetcode.smart;


public class work0082 {
	public ListNode deleteDuplicates2(ListNode head) {
		ListNode real = new ListNode();
		real.next = head;
		ListNode cur = head;
		ListNode pre = real;
		while(cur != null && cur.next!=null) {
			if(cur.val == cur.next.val) {
				while(cur.next!=null&&cur.val == cur.next.val) {
					cur = cur.next;
				}
				cur = cur.next;
				pre.next = cur;
			}else {
				pre = pre.next;
				cur = cur.next;
			}
		}
		return real.next;
	}
	public ListNode deleteDuplicates(ListNode head) {
		//自己的解法,处理头结点逻辑复杂
		if(head==null||head.next==null) return head;
		while(head.next!=null&&head.val==head.next.val) {
			while(head.next!=null&&head.val==head.next.val) {
				head = head.next;
			}
			if(head.next==null) return head.next;
			head = head.next;
		}
		if(head==null||head.next==null) return head;
		ListNode now = head.next;
		ListNode pre = head;
		while(now!=null&&now.next!=null) {
			if(now.val==now.next.val) {
				while(now.next!=null&&now.val==now.next.val) {
					now.next = now.next.next;
				}
				pre.next = now.next;
				now = pre.next;
			}else {
				pre = pre.next;
				now = now.next;
			}
		}
		return head;
	}
	public static void main(String[] args) {
		work0082 w= new work0082();
		ListNode head = new ListNode(1,1,1,2,2,3);
//		System.out.println(head);
		System.out.println(w.deleteDuplicates2(head));
	}
}

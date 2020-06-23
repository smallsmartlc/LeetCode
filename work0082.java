package Leetcode.smart;


public class work0082 {
	public ListNode deleteDuplicates2(ListNode head) {
		if(head==null||head.next==null) return head;
		//防止头结点重复,定义一个头结点
		ListNode realHead = new ListNode(0);
		realHead.next = head;
		ListNode now = realHead.next;
		ListNode pre = realHead;
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
		return realHead.next;
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

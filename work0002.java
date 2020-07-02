package Leetcode.smart;



public class work0002 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode l3 = new ListNode(0);
		ListNode cur = l3;
		ListNode p = l1;
		ListNode q = l2;
		int carry = 0;
		while(p!=null||q!=null) {
			int x = p!=null?p.val:0;
			int y = q!=null?q.val:0;
			int sum = x+y+carry;
			carry = sum/10;
			cur.next = new ListNode(sum%10);
			cur = cur.next;
			if(p!=null)p = p.next;
			if(q!=null)q = q.next;
		}
		if (carry>0) cur.next = new ListNode(carry);
		return l3.next;
    }
	public static void main(String[] args) {
		work0002 w = new work0002();
		ListNode l1 = new ListNode(2,4,3);
		ListNode l2 = new ListNode(5,6,4);
		System.out.println(w.addTwoNumbers(l1, l2));
	}
}




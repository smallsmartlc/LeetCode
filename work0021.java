package Leetcode.smart;

public class work0021 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		if(l1.val<l2.val) {
			l1.next =  mergeTwoLists(l1.next, l2);
			return l1;
		}else {
			l2.next =  mergeTwoLists(l1, l2.next);
			return l2;
		}
    }
	public static void main(String[] args) {
		work0021 w = new work0021();
		ListNode n2 = new ListNode(1,3,4);
		ListNode n1 = new ListNode(1,2,4);
		System.out.println(w.mergeTwoLists(n1,n2));
	}
}

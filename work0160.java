package Leetcode.smart;

public class work0160 {
	public static void main(String[] args) {
		work0160 w = new work0160();
		ListNode l1 = new ListNode(4,1);
		ListNode l2 = new ListNode(5,0,1);
		ListNode l3 = new ListNode(8,4,5);
		ListNode cur = l1;
		while(cur.next!=null) {
			cur = cur.next;
		}
		cur.next = l3;
		cur = l2;
		while(cur.next!=null) {
			cur = cur.next;
		}
		cur.next = l3;
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(w.getIntersectionNode(l1, l2));
	}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while(cur1!=cur2) {
        	cur1 = cur1==null?headB:cur1.next;
        	cur2 = cur2==null?headA:cur2.next;
        }
        return cur1;
    }
}


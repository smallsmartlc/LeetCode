package Leetcode.smart;

import java.util.List;

/**
 * leetcode 0328. 奇偶链表
 */
public class work0328 {

    public static void main(String[] args) {
        work0328 w = new work0328();
        ListNode head = new ListNode(1,2,3,4,5,6,7,8);
        System.out.println(w.oddEvenList(head));
    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode evenHead = new ListNode();
        ListNode even = evenHead;
        ListNode cur = head;
        while (cur.next !=null){
            even.next = cur.next;
            cur.next = cur.next.next;
            even = even.next;
            even.next = null;
            if(cur.next != null)cur = cur.next;
        }
        cur.next = evenHead.next;
        return head;
    }
}


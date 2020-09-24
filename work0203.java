package Leetcode.smart;


public class work0203 {
    public static void main(String[] args) {
        work0203 w = new work0203();
        ListNode head = new ListNode(1, 2, 3, 6, 4, 5, 6);
        System.out.println(w.removeElements(head, 6));
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode realHead = new ListNode();
        realHead.next = head;

        ListNode cur = realHead;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return realHead.next;

    }
}
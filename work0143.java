package Leetcode.smart;

public class work0143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur.next != null) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        ListNode temp = head.next;
        head.next = cur;
        cur.next = temp;
        reorderList(head.next.next);
    }

    public static void main(String[] args) {
        work0143 w = new work0143();
        ListNode head = new ListNode(1, 2, 3, 4, 5);
        System.out.println(head);
        w.reorderList(head);
        System.out.println(head);
    }
}

package Leetcode.smart;


public class work0206 {
    public static void main(String[] args) {
        work0206 w = new work0206();
        ListNode head = new ListNode(1, 2, 3, 4, 5, 6);
        System.out.println(w.reverseList1(head));
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        //将链表方向转换,并返回原来的尾节点
        return res;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode realhead = new ListNode();
        realhead.next = head;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            temp.next = realhead.next;
            realhead.next = temp;
        }
        return realhead.next;
    }
}
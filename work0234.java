package Leetcode.smart;

import java.util.List;

/**
 * 234 . 回文链表
 */
public class work0234 {

    public static void main(String[] args) {

        work0234 w = new work0234();
        ListNode head = new ListNode(1, 2, 1);
        System.out.println(w.isPalindrome(head));
    }

    ListNode temp = null;

    public boolean isPalindrome(ListNode head) {
        temp = head;
        return check(head);
    }

    private boolean check(ListNode head) {
        if(head == null) return true;
        boolean res = check(head.next) && (temp.val == head.val);
        temp = temp.next;
        return res;
    }

}


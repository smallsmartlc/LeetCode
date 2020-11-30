package Leetcode.smart;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 237. 删除链表中的节点
 */
public class work0237 {

    public static void main(String[] args) {

        work0237 w = new work0237();
        ListNode head = new ListNode(4, 5, 1, 9);
        System.out.println(head);
        w.deleteNode(head.next);
        System.out.println(head);
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}


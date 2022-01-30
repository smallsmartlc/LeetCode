package Leetcode.smart;

import java.util.Comparator;
import java.util.PriorityQueue;

//23. 合并K个升序链表
public class work0023 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            while (node != null){
                queue.offer(node);
                node = node.next;
            }
        }
        ListNode head = new ListNode();
        ListNode cur = head;
        while (!queue.isEmpty()){
            cur.next = queue.poll();
            cur = cur.next;
        }
        cur.next = null;
        return head.next;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    public ListNode mergeKLists0(ListNode[] lists) {
        if(lists.length < 1) return null;
        ListNode head = null;
        for (ListNode list : lists) {
            head = mergeTwoLists(head,list);
        }
        return head;
    }


    public static void main(String[] args) {
        work0023 w = new work0023();
        ListNode l1 = new ListNode(1,4,5);
        ListNode l2 = new ListNode(1,3,4);
        ListNode l3 = new ListNode(2,6);
        System.out.println(w.mergeKLists(new ListNode[]{l1,l2,l3}));
    }
}

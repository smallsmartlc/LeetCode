package Leetcode.smart;

import java.util.HashMap;

import Leetcode.smart.带随机指针的链表.Node;

public class work0138 {
	HashMap<Node,Node> hash = new HashMap<>();
	public Node copyRandomList(Node head) {
        if(head == null) return null;
        if(hash.containsKey(head)) {
        	return hash.get(head);
        }
        Node node = new Node(head.val);
        hash.put(head, node);
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);
        
        return node;
    }
	public static void main(String[] args) {
		work0138 w = new work0138();
		Node node1 = new Node(7);
		Node node2 = new Node(13);
		Node node3 = new Node(11);
		Node node4 = new Node(10);
		Node node5 = new Node(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node1.random = null;
		node2.random = node2;
		node3.random = node4;
		node4.random = node2;
		node5.random = null;
		System.out.println(w.copyRandomList(node1));
		
	}
}

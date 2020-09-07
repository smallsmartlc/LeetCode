package Leetcode.smart;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Leetcode.smart.¿ËÂ¡Í¼.Node;

public class work0133 {
	Map<Integer, Node> map = new HashMap<>();
	public Node cloneGraph(Node node) {
		if (node == null) return node;
		if (map.containsKey(node.val)) return map.get(node.val);
		Node cloneNode = new Node(node.val, new ArrayList());
		map.put(cloneNode.val, cloneNode);
		for (Node n : node.neighbors) {
			cloneNode.neighbors.add(cloneGraph(n));
		}
		return cloneNode;
	}
	
	public static void main(String[] args) {
		work0133 w= new work0133();
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		node1.neighbors = new ArrayList<>();
		node1.neighbors.add(node2);
		node1.neighbors.add(node4);
		node2.neighbors = new ArrayList<>();
		node2.neighbors.add(node1);
		node2.neighbors.add(node3);
		node3.neighbors = new ArrayList<>();
		node3.neighbors.add(node2);
		node3.neighbors.add(node4);
		node4.neighbors = new ArrayList<>();
		node4.neighbors.add(node1);
		node4.neighbors.add(node3);
		Node res = w.cloneGraph(node1);
		System.out.println();
	}
}

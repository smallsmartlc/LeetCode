package Leetcode.smart;


import java.util.LinkedList;
import java.util.Queue;

public class work0117 {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            while(n>0){
                n--;
                Node poll = queue.poll();
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
                if(n>0) poll.next = queue.peek();
            }
        }
        return root;
    }


    public static void main(String[] args) {
        work0117 w = new work0117();
        Node p = Node.node(1, 2, 3, 4, 5, 6, 7);
        Node connect = w.connect(p);
        System.out.println();
    }
}

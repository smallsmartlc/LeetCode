package Leetcode.smart;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * leetcode 0272 最接近的二叉搜索树值 II
 * lintcode 900. 二叉搜索树中最接近的值 II
 */
public class work0272 {

    public static void main(String[] args) {
        work0272 w = new work0272();
        TreeNode root = TreeNode.treeNode(2, 1, 3);
        System.out.println(w.closestKValues(root, 5.571429d, 2));
    }

    private Map<TreeNode, TreeNode> map = new HashMap<>();

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        LinkedList<Integer> list = new LinkedList<>();
        TreeNode closest = root;
        while (root != null) {
            int val = root.val;
            double thisAbs = Math.abs(val - target);
            double minAbs = Math.abs(closest.val - target);
            if (thisAbs < minAbs) {
                closest = root;
            }
            if (target < val) {
                map.put(root.left, root);
                root = root.left;
            } else {
                map.put(root.right, root);
                root = root.right;
            }
        }
        list.add(closest.val);
        TreeNode smaller = getPreNode(closest);
        TreeNode larger = getNextNode(closest);
        while (list.size() < k) {
            if (smaller == null || (larger != null && (target - smaller.val) > (larger.val - target))) {
                list.add(larger.val);
                larger = getNextNode(larger);
            } else {
                list.add(smaller.val);
                smaller = getPreNode(smaller);
            }
        }
        return list;
    }

    private TreeNode getPreNode(TreeNode node) {
        if (node.left == null) {
            // 没有左子,如果为父节点的右子,则前驱为父节点,若为父节点的左子,继续往上找,直到为右子
            while (map.get(node) != null && map.get(node).right != node) {
                node = map.get(node);
            }
            return map.get(node);
        } else {
            // 有左子,前驱为left的最右子
            map.put(node.left, node);
            node = node.left;
            while (node.right != null) {
                map.put(node.right, node);
                node = node.right;
            }
            return node;
        }
    }

    private TreeNode getNextNode(TreeNode node) {
        if (node.right == null) {
            while (map.get(node) != null && map.get(node).left != node) {
                node = map.get(node);
            }
            return map.get(node);
        } else {
            map.put(node.right, node);
            // 后继为right的最左子
            node = node.right;
            while (node.left != null) {
                map.put(node.left, node);
                node = node.left;
            }
            return node;
        }
    }
}


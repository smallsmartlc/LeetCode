package Leetcode.smart;

import java.util.*;

/**
 * LeetCode99.恢复二叉搜索树
 */
public class work0099 {

    public void recoverTree4(TreeNode root) {
        // Morris 中序遍历 Map版本
        HashMap<TreeNode, TreeNode> rightMap = new HashMap<>();//map替代.right引用
        TreeNode pre = null; // 替代栈,表示顺序的前一个值
        TreeNode first = null;
        TreeNode second = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                if (pre != null && pre.val > cur.val) {
                    second = cur;
                    if (first == null) {
                        first = pre;
                    }else{
                        break;//这里使用map后可以break
                    }
                }
                pre = cur; // 左子树为空,则中序遍历为中-右,将当前节点添加入顺序队列
                cur = cur.right == null ? rightMap.get(cur) : cur.right;// 继续遍历右节点,当cur是map里的节点right为null
            } else {
                // 左子树不为空,所以遍历到左子树的最后一个节点需要回到中间
                // 利用左子树最后一个节点的右节点为空可以将右节点连接回根节点
                // 将leftCur,cur放入map
                TreeNode leftCur = cur.left;
                while (leftCur.right != null) {
                    leftCur = leftCur.right;
                }
                if (rightMap.containsKey(leftCur)) { // leftCur.right = cur,说明现在处理到左子树最后一个节点,该返回到根节点了
                    if (pre != null && pre.val > cur.val) {
                        second = cur;
                        if (first == null) {
                            first = pre;
                        }else{
                            break;//这里使用map后可以break
                        }
                    }
                    pre = cur; // 左子树处理完了,将根节点加入
                    cur = cur.right == null ? rightMap.get(cur) : cur.right; // 继续遍历右子树
                } else {
                    // 先找到左子树的最右节点
                    rightMap.put(leftCur, cur);// 连接到root等待左子树其它节点加入顺序队列
                    cur = cur.left; // 开始按左-中-右顺序遍历该树
                }
            }
        }
        swap(first, second);
    }

    public void recoverTree3(TreeNode root) {
        // Morris 中序遍历 空间复杂度O(1)的解法
        TreeNode pre = null; // 替代栈,表示顺序的前一个值
        TreeNode first = null;
        TreeNode second = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                if (pre != null && pre.val > cur.val) {
                    if (first == null) first = pre;
                    second = cur;//这里不能break因为右叶子节点的连接未断开
                }
                pre = cur; // 左子树为空,则中序遍历为中-右,将当前节点添加入顺序队列
                cur = cur.right; // 继续遍历右节点
            } else {
                // 左子树不为空,所以遍历到左子树的最后一个节点需要回到中间
                // 利用左子树最后一个节点的右节点为空可以将右节点连接回根节点
                // 但是产生了循环链表,所以我们需要在添加入队列后断开
                // 并且必须把所有的循环节点都断开之后才能返回,所以不能提前break
                // 这里如果不想频繁的产生循环链表,可以用map替代引用关系,但是空间复杂度就提升了
                TreeNode leftCur = cur.left;
                while (leftCur.right != null && leftCur.right != cur) {
                    leftCur = leftCur.right;
                }
                if (leftCur.right == null) {
                    // 先找到左子树的最右节点
                    leftCur.right = cur;// 连接到root等待左子树其它节点加入顺序队列
                    cur = cur.left; // 开始按左-中-右顺序遍历该树
                } else { // leftCur.right = cur,说明现在处理到左子树最后一个节点,该返回到根节点了
                    if (pre != null && pre.val > cur.val) {
                        if (first == null) first = pre;
                        second = cur;//这里不能break因为右叶子节点的连接未断开
                    }
                    leftCur.right = null;// 断开
                    pre = cur; // 左子树处理完了,将根节点加入
                    cur = cur.right; // 继续遍历右子树
                }
            }
        }
        swap(first, second);
    }


    TreeNode previous = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree2(TreeNode root) {
        // 尝试使用递归
        inorderTraversal(root);
        swap(first, second);
    }

    private void inorderTraversal(TreeNode root) {
        // 和迭代法相同
        if (root == null) return;
        inorderTraversal(root.left);
        if (previous != null && root.val < previous.val) {
            if (first == null) { // 第一次找到
                first = previous;
                second = root;// 如果第二次没有找到,说明两个被调换的元素相邻
            } else {
                //如果第二次找到了,说明两个被调换的元素不相邻
                second = root; // 更新second
                return;
            }
        }
        previous = root;
        inorderTraversal(root.right);
    }


    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode previous = null; // 记录中序遍历顺序的前一个节点
        TreeNode first = null;
        TreeNode second = null;
        while (cur != null || !stack.isEmpty()) {
            // 中序遍历
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (previous != null && cur.val < previous.val) {
                // 顺序不对,说明找到了被调换的元素,循环过程最多满足这个条件两次
                if (first == null) { // 第一次找到
                    first = previous;
                    second = cur;// 如果第二次没有找到,说明两个被调换的元素相邻
                } else {
                    //如果第二次找到了,说明两个被调换的元素不相邻
                    second = cur; // 更新second
                    break; // 不需要继续迭代了
                }
            }
            previous = cur;
            cur = cur.right;
        }
        swap(first, second);
    }

    private void swap(TreeNode i, TreeNode j) {
        int temp = i.val;
        i.val = j.val;
        j.val = temp;
    }

    public static void main(String[] args) {
        work0099 w = new work0099();
        TreeNode root = TreeNode.treeNode(2,3,null,1);
        w.recoverTree4(root);
        System.out.println(root);
    }
}

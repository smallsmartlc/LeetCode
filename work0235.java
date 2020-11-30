package Leetcode.smart;

/**
 * 235.二叉搜索树的最近公共祖先
 */
public class work0235 {

    public static void main(String[] args) {

        work0235 w = new work0235();
        TreeNode root = TreeNode.treeNode(6,2,8,0,4,7,9,null,null,3,5);
        TreeNode p = root.left;
        TreeNode q = root.right;
        System.out.println(w.lowestCommonAncestor(root,p,q));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while(true){
            if(cur.val > p.val && cur.val > q.val){
                cur = cur.left;
            }else if (cur.val < p.val && cur.val < q.val){
                cur = cur.right;
            }else{
                break;
            }
        }
        return cur;
    }
}


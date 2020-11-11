package Leetcode.smart;

/**
 * 222. 完全二叉树的节点个数
 */
public class work0223 {


    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long x = (long)Math.min(C, G) - Math.max(A, E);
        long y = (long)Math.min(D, H) - Math.max(B, F);
        return (int)((C - A) * (D - B) - Math.max(0, x) * Math.max(0, y) + (G - E) * (H - F));
    }

    public static void main(String[] args) {
        work0223 w = new work0223();
//        System.out.println(w.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println(w.computeArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1));
    }
}

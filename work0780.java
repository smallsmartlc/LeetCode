package Leetcode.smart;

/**
 * 0780 到达终点
 */

public class work0780 {
    public static void main(String[] args) {
        work0780 w = new work0780();
        System.out.println(w.reachingPoints(1, 1, 3, 5));
    }

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) return true;
        if (sx > tx || sy > ty) return false;
        if (sx == tx) return (ty - sy) % sx == 0;
        if (sy == ty) return (tx - sx) % sy == 0;
        return tx >= ty ? reachingPoints(sx, sy, tx % ty, ty) : reachingPoints(sx, sy, tx, ty % tx);
    }

}
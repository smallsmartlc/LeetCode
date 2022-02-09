package Leetcode.smart;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode1001 网格照明
 *
 * @author LuCong
 * @since 2022-2-9
 **/
public class work1001 {
    public static void main(String[] args) {
        work1001 w = new work1001();
        int[][] lamps = LecoUtil.LecoNewNums(2, 2, 0, 0, 4, 4);
        int[][] queries = LecoUtil.LecoNewNums(2, 2, 1, 1, 1, 1);
        LecoUtil.LecoPrint(w.gridIllumination(5, lamps, queries));
    }

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        int l = lamps.length;
        HashMap<Integer, Integer> row = new HashMap<>(l);
        HashMap<Integer, Integer> col = new HashMap<>(l);
        HashMap<Integer, Integer> diagonal = new HashMap<>(l);
        HashMap<Integer, Integer> antiDiagonal = new HashMap<>(l);
        Set<Long> turned = new HashSet<>(l);
        for (int[] lamp : lamps) {
            int x = lamp[0];
            int y = lamp[1];
            if (turned.contains(hash(x,y))) {
                continue;
            }
            row.put(x, row.getOrDefault(x, 0) + 1);
            col.put(y, col.getOrDefault(y, 0) + 1);
            diagonal.put(x - y, diagonal.getOrDefault(x - y, 0) + 1);
            antiDiagonal.put(x + y, antiDiagonal.getOrDefault(x + y, 0) + 1);
            turned.add(hash(x,y));
        }
        int len = queries.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            if (row.getOrDefault(x, 0) > 0 ||
                    col.getOrDefault(y, 0) > 0 ||
                    diagonal.getOrDefault(x - y, 0) > 0 ||
                    antiDiagonal.getOrDefault(x + y, 0) > 0) {
                res[i] = 1;
            }
            for (int yi = y - 1; yi < y + 2; yi++) {
                for (int xi = x - 1; xi < x + 2; xi++) {
                    if (xi < 0 || yi < 0 || xi > n - 1 || yi > n - 1) continue;
                    if (!turned.remove(hash(xi,yi))) continue;
                    row.compute(xi, (k, v) -> v - 1);
                    col.compute(yi, (k, v) -> v - 1);
                    diagonal.compute(xi - yi, (k, v) -> v - 1);
                    antiDiagonal.compute(xi + yi, (k, v) -> v - 1);
                }
            }
        }
        return res;
    }

    private long hash(int x, int y) {
        return ((long) y << 32) + x;
    }
}



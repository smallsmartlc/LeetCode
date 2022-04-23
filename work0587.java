package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

/**
 * 0587 安装栅栏
 */

public class work0587 {
    public static void main(String[] args) {
        work0587 w = new work0587();

    }

    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if (n < 4) {
            return trees;
        }
        int leftNode = 0;
        for (int i = 1; i < n; i++) {
            if (trees[i][0] < trees[leftNode][0]) leftNode = i;
        }
        List<int[]> res = new ArrayList<>();
        boolean[] visit = new boolean[n];
        int first = leftNode;
        for (int i = (first + 1) % n; true; i = (i + 1) % n) {
            // 遍历除它以外的所有点,组成一个向量
            for (int j = 0; j < n; j++) {
                if (cross(trees[first], trees[i], trees[j]) < 0) {
                    i = j; // 如果j 在 first - i右侧,将i更新为j
                }
            }
            // 检查是否存在三点一条线都被围到的情况
            for (int center = 0; center < n; center++) {
                if (visit[center] || center == first || center == i) {
                    continue;
                }
                if (cross(trees[first], trees[i], trees[center]) == 0) {
                    res.add(trees[center]);
                    visit[center] = true;
                }
            }
            if (!visit[i]) {
                res.add(trees[i]);
                visit[i] = true;
            }
            first = i;
            if (first == leftNode) break;
        }
        return res.toArray(new int[][]{});
    }

    public int cross(int[] p, int[] q, int[] r) {
        return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
    }

}
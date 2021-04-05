package Leetcode.smart;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * LeetCode0305 岛屿数量 II  (会员)
 * LintCode 434 · 岛屿的个数II
 */
public class work0305 {
    public static void main(String[] args) {
        work0305 w = new work0305();
//        System.out.println(w.numIslands2(1, 1, new Point[]{}));
        System.out.println(w.numIslands2(8, 14,
                new Point[]{new Point(0, 9), new Point(5, 4), new Point(0, 12)
                        , new Point(6, 9), new Point(6, 5), new Point(0, 4)}));
    }

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (operators == null) return res;
        int[] tree = new int[m * n];
        Arrays.fill(tree, -1);
        //让遍历四周变得优雅一点
        int[][] dicts = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int num = 0;
        for (Point operator : operators) {
            int id = operator.x * m + operator.y;
            if (tree[id] != -1) {
                res.add(num);
                continue;
            }
            // 放个岛
            tree[id] = id;//父节点为自己
            num++;
            for (int[] dict : dicts) {
                int x = dict[0] + operator.x;
                int y = dict[1] + operator.y;
                int curId = m * x + y;
                if (x < 0 || x >= n || y < 0 || y >= m || tree[curId] == -1) // 越界或该位置是水，直接跳过
                    continue;
                // 检查是否将岛屿连在一起
                int p = find(tree, curId), q = find(tree, id);
                if (p != q) {
                    tree[p] = q;
                    num--;
                }
            }
            res.add(num);
        }
        return res;
    }

    private int find(int[] tree, int id) {
        if (tree[id] != id) {
            tree[id] = find(tree, tree[id]);    // 路径压缩
            // 这个过程只要连在一起,岛的数字都会相同
        }
        return tree[id];
    }


    private static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

}
package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode0417 太平洋大西洋水流问题
 */

public class work0417 {
    public static void main(String[] args) {
        work0417 w = new work0417();
        int[][] height = LecoUtil.LecoNewNums(5, 5,
                1, 2, 2, 3, 5, 3, 2, 3, 4, 4, 2, 4, 5, 3, 1, 6, 7, 1, 4, 5, 5, 1, 1, 2, 4);
        System.out.println(w.pacificAtlantic(height));
    }

    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m;
    private int n;
    private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        this.heights = heights;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
            dfs(i, n - 1, atlantic);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, pacific);
            dfs(m - 1, i, atlantic);
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private void dfs(int row, int col, boolean[][] ocean) {
        if (ocean[row][col]) return;
        ocean[row][col] = true;
        for (int[] dir : dirs) {
            int r = row + dir[0], c = col + dir[1];
            if (r < 0 || r >= m || c < 0 || c >= n) continue;
            if (heights[r][c] >= heights[row][col]) dfs(r, c, ocean);
        }
    }
}
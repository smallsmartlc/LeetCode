package Leetcode.smart;

/**
 * LeetCode1020 飞地的数量
 *
 * @author LuCong
 * @since 2022-2-9
 **/
public class work1020 {
    public static void main(String[] args) {
        work1020 w = new work1020();
//        int[][] grid = LecoUtil.LecoNewNums(4, 4,
//                0, 0, 0, 0,
//                1, 0, 1, 0,
//                0, 1, 1, 0,
//                0, 0, 0, 0);
        int[][] grid = LecoUtil.LecoNewNums(10, 10,
                0, 0, 0, 1, 1, 1, 0, 1, 0, 0,
                1, 1, 0, 0, 0, 1, 0, 1, 1, 1,
                0, 0, 0, 1, 1, 1, 0, 1, 0, 0,
                0, 1, 1, 0, 0, 0, 1, 0, 1, 0,
                0, 1, 1, 1, 1, 1, 0, 0, 1, 0,
                0, 0, 1, 0, 1, 1, 1, 1, 0, 1,
                0, 1, 1, 0, 0, 0, 1, 1, 1, 1,
                0, 0, 1, 0, 0, 1, 0, 1, 0, 1,
                1, 0, 1, 0, 1, 1, 0, 0, 0, 0,
                0, 0, 0, 0, 1, 1, 0, 0, 0, 1);
        System.out.println(w.numEnclaves(grid));
    }

    public int numEnclaves(int[][] grid) {
        // 深度优先搜索,从边上查,被查到的就可以排除
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 1; i < n - 1; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(grid, 0, i);
            dfs(grid, n - 1, i);
        }
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 1) res++;
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) {
            return;
        }
        grid[row][col] = -1; // 表示已访问过
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}



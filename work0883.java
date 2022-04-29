package Leetcode.smart;

/**
 * 0883 三维形体投影面积
 */

public class work0883 {
    public static void main(String[] args) {
        work0883 w = new work0883();
        System.out.println(w.projectionArea(LecoUtil.LecoNewNums(2, 2, 1, 2, 3, 4)));
    }

    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int[] rowMax = new int[n]; // 侧视图
        int[] colMax = new int[n]; // 正视图
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > rowMax[i]) rowMax[i] = grid[i][j];
                if (grid[i][j] > colMax[j]) colMax[j] = grid[i][j];
                if (grid[i][j] > 0) area++; // 俯视图
            }
        }
        for (int i = 0; i < n; i++) {
            area += rowMax[i] + colMax[i];
        }
        return area;
    }
}
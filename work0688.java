package Leetcode.smart;

/**
 * LeetCode0688 骑士在棋盘上的概率
 */

public class work0688 {
    public static void main(String[] args) {
        work0688 w = new work0688();
        System.out.println(w.knightProbability(8, 30, 6, 4));
        System.out.println(w.knightProbability2(8, 30, 6, 4));
    }

    static int[][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        for (int step = 0; step < k + 1; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (step == 0) dp[step][i][j] = 1;
                    else {
                        for (int[] dir : dirs) {
                            int x = i + dir[0];
                            int y = j + dir[1];
                            if (x > -1 && x < n && y > -1 && y < n) {
                                dp[step][i][j] += dp[step - 1][x][y] / 8;
                            }
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }

    private double[][][] dp;

    public double knightProbability2(int n, int k, int row, int column) {
        // 记忆化搜索
        dp = new double[k + 1][n][n];
        return dfs(n, k, row, column);
    }

    private double dfs(int n, int k, int row, int col) {
        if (row < 0 || row > n - 1 || col < 0 || col > n - 1) return 0;
        if (k == 0) return 1;
        if (dp[k][row][col] != 0) return dp[k][row][col];
        double ans = 0;
        for (int[] dir : dirs) {
            ans += dfs(n, k - 1, row + dir[0], col + dir[1]) / 8;
        }
        dp[k][row][col] = ans;
        return ans;
    }
}
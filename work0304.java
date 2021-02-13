package Leetcode.smart;

/**
 * LeetCode0304 二维区域和检索 - 矩阵不可变
 */
public class work0304 {

    public static void main(String[] args) {
        work0304 w = new work0304();
        int[][] nums = LecoUtil.LecoNewNums(5, 5
                , 3, 0, 1, 4, 2
                , 5, 6, 3, 2, 1
                , 1, 2, 0, 1, 5
                , 4, 1, 0, 1, 7
                , 1, 0, 3, 0, 5
        );
        NumMatrix obj = new NumMatrix(nums);
        System.out.println(obj.sumRegion(1, 1, 2, 2));
    }

    private static class NumMatrix {

        private int[][] dp;

        public NumMatrix(int[][] matrix) {
            int n = matrix.length;
            if(n < 1) return;
            int m = matrix[0].length;
            dp = new int[n+1][m+1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + matrix[i-1][j-1];
                }
            }
        }
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2+1][col2+1] - dp[row2+1][col1] - dp[row1][col2+1] + dp[row1][col1];
        }
    }

}


package Leetcode.smart;

//221. 最大正方形

public class work0221 {
    public static void main(String[] args) {
        work0221 w = new work0221();
        char[][] chars = LecoUtil.LecoNewChars(5, 4,
                '1', '0', '1', '0', '0',
                '1', '0', '1', '1', '1',
                '1', '1', '1', '1', '1',
                '1', '0', '0', '1', '0'
        );
        char[][] chars2 = new char[][]{
                {'1', '1', '0', '1'},
                {'1', '1', '0', '1'}, {'1', '1', '1', '1'}};
        System.out.println(w.maximalSquare3(chars2));
    }

    //动态规划,原地算法,优化时间空间复杂度
    //执行用时：5 ms, 在所有 Java 提交中击败了91.14%的用户内存消耗：42.2 MB, 在所有 Java 提交中击败了27.08%的用户
    public int maximalSquare3(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            //位运算优化
            if (maxLen > 0) break;
            maxLen |=  matrix[i][m - 1] - '0';
            //找到有1,更新最大长度,退出
//            if (matrix[i][m - 1] > '0') {
//                maxLen = 1;
//                break;
//            }
        }
        for (int i = 0; i < m; i++) {
            if (maxLen > 0) break;
            maxLen |=  matrix[n - 1][i] - '0';
//            if (matrix[n - 1][i] > '0') {
//                maxLen = 1;
//                break;
//            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                if (matrix[i][j] > '0') {
                    matrix[i][j] += Math.min(Math.min(matrix[i + 1][j], matrix[i][j + 1]), matrix[i + 1][j + 1]) - '0';
                    if (matrix[i][j] - '0' > maxLen) maxLen = matrix[i][j] - '0';
                }
            }
        }
        return maxLen * maxLen;
    }

    //动态规划
    // 执行用时：9 ms, 在所有 Java 提交中击败了9.00%的用户内存消耗：42 MB, 在所有 Java 提交中击败了56.96%的用户
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            dp[i][m - 1] = matrix[i][m - 1] - '0';
            if (maxLen < 1 && dp[i][m - 1] > 0){} maxLen = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[n - 1][i] = matrix[n - 1][i] - '0';
            if (maxLen < 1 && dp[n - 1][i] > 0) maxLen = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j] = matrix[i][j] - '0';
                if (dp[i][j] > 0) {
                    dp[i][j] += Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i + 1][j + 1]);
                    if (dp[i][j] > maxLen) maxLen = dp[i][j];
                }
            }
        }

        return maxLen * maxLen;
    }


    //暴力法 + 窗口优化
    // 执行用时：4 ms, 在所有 Java 提交中击败了98.68%的用户内存消耗：41.7 MB, 在所有 Java 提交中击败了85.27%的用户
    private int len = 0;

    public int maximalSquare1(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        for (int i = 0; i < n - len; i++) {
            for (int j = 0; j < m - len; j++) {
                if (matrix[i][j] == '0') continue;
                if (len < 1) len = 1;
                if (!isBiggest(matrix, i, j)) {
                    continue;
                }
            }
        }
        return len * len;
    }

    private boolean isBiggest(char[][] matrix, int y, int x) {
        int n = matrix.length;
        int m = matrix[0].length;
        int curMax = Math.min(n - y, m - x);
        if (curMax < len) return false;
        for (int i = 1; i < curMax; i++) {
            if (matrix[y + i][x + i] == '0') return false;
            for (int j = 0; j < i; j++) {
                if (matrix[y + j][x + i] == '0' || matrix[y + i][x + j] == '0') return false;
            }
            len = Math.max(len, i + 1);
        }
        return true;
    }

}
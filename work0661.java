package Leetcode.smart;

/**
 * 0661 图片平滑器
 */

public class work0661 {
    public static void main(String[] args) {
        work0661 w = new work0661();
        int[][] ints = LecoUtil.LecoNewNums(3, 3,
                100, 200, 100, 200, 50, 200, 100, 200, 100);
        LecoUtil.LecoPrint(w.imageSmoother(ints));
    }

    public int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = 0;
                int sum = 0;
                for (int x = -1; x < 2; x++) {
                    for (int y = -1; y < 2; y++) {
                        if (i + x < 0 || i + x == n || j + y < 0 || j + y == m) continue;
                        sum += img[i + x][j + y];
                        num++;
                    }
                }
                res[i][j] = sum / num;
            }
        }
        return res;
    }
}
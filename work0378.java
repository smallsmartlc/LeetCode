package Leetcode.smart;


/**
 * LeetCode0378 有序矩阵中第 K 小的元素
 */
public class work0378 {
    public static void main(String[] args) {
        work0378 w = new work0378();
        int[][] matrix = LecoUtil.LecoNewNums(3, 3,
                1, 5, 9,
                10, 11, 13,
                12, 13, 15);
        System.out.println(w.kthSmallest(matrix, 8));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1];
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            int num = check(matrix, mid);
            if (num >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int check(int[][] matrix, int mid) {
        int n = matrix.length;
        int i = n - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                count += i + 1; // 统计该列的数
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}
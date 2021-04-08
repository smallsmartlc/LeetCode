package Leetcode.smart;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * LeetCode0311 稀疏矩阵的乘法 (会员)
 * LintCode 654 · 稀疏矩阵乘法
 */
public class work0311 {
    public static void main(String[] args) {
        work0311 w = new work0311();
        int[][] A = LecoUtil.LecoNewNums(3, 2, 1, 0, 0, -1, 0, 3);
        int[][] B = LecoUtil.LecoNewNums(3, 3, 7, 0, 0, 0, 0, 0, 0, 0, 1);
        LecoUtil.LecoPrint(w.multiply(A, B));
    }

    public int[][] multiply0(int[][] A, int[][] B) {
        // 暴力法
        int m1 = A.length;
        int n1 = A[0].length;
        int m2 = B.length;
        int n2 = B[0].length;

        int[][] res = new int[m1][n2];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                int sum = 0;
                for (int k = 0; k < n1; k++) {
                    sum += A[i][k] * B[k][j];
                }
                res[i][j] = sum;
            }
        }
        return res;
    }

    public int[][] multiply(int[][] A, int[][] B) {
        // 优化都是0的列或行
        int m1 = A.length;
        int n1 = A[0].length;
        int m2 = B.length;
        int n2 = B[0].length;
        boolean[] flagA = new boolean[m1];
        boolean[] flagB = new boolean[n2];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                if (A[i][j] != 0) {
                    flagA[i] = true;
                    j = n1;//跳出循环;
                }
            }
        }
        for (int j = 0; j < n2; j++) {
            for (int i = 0; i < m2; i++) {
                if (B[i][j] != 0) {
                    flagB[j] = true;
                    i = m2;//跳出循环;
                }
            }
        }
        int[][] res = new int[m1][n2];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                int sum = 0;
                if (flagA[i] && flagB[j]) {
                    for (int k = 0; k < n1; k++) {
                        sum += A[i][k] * B[k][j];
                    }
                    res[i][j] = sum;
                }
            }
        }
        return res;
    }

}
package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode1380 矩阵中的幸运数
 *
 * @author LuCong
 * @since 2020-10-30
 **/
public class work1380 {
    public static void main(String[] args) {
        work1380 w = new work1380();
        int[][] matrix = LecoUtil.LecoNewNums(3, 3,
                3, 7, 8, 9, 11, 13, 15, 16, 17);
        System.out.println(w.luckyNumbers(matrix));
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] rowMin = new int[n];
        int[] colMax = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = matrix[i][j];
                if (num < matrix[i][rowMin[i]]) rowMin[i] = j;
                if (num > matrix[colMax[j]][j]) colMax[j] = i;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < rowMin.length; i++) {
            if (colMax[rowMin[i]] == i) res.add(matrix[i][rowMin[i]]);
        }
        return res;
    }
}








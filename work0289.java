package Leetcode.smart;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 0287. 寻找重复数
 */
public class work0289 {

    public static void main(String[] args) {

        work0289 w = new work0289();
        int[][] nums = LecoUtil.LecoNewNums(3, 4, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0);
        LecoUtil.LecoPrint(nums);
        w.gameOfLife(nums);
        LecoUtil.LecoPrint(nums);

    }

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int check = check(board, i, j);
                if (board[i][j] > 0) {
                    if (check < 2 || check > 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (check == 3) {
                        board[i][j] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int check(int[][] board, int y, int x) {
        int n = board.length;
        int m = board[0].length;
        int res = 0;
        for (int i = y - 1; i < y + 2; i++) {
            if (i < 0 || i > n - 1) continue;
            for (int j = x - 1; j < x + 2; j++) {
                if (j == x && i == y) continue;
                if (j < 0 || j > m - 1 || board[i][j] < 1) continue;
                res++;
            }
        }
        return res;
    }
}


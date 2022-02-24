package Leetcode.smart;

//LeetCode1706 球会落何处

public class work1706 {
    public static void main(String[] args) {
        work1706 w = new work1706();
        LecoUtil.LecoPrint(w.findBall(LecoUtil.LecoNewNums(5, 5, 1, 1, 1, -1, -1, 1, 1, 1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1,
                -1, -1)));
    }

    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int index = i;// 球的初始位置
            for (int[] board : grid) {
                int next = board[index];
                index += next;
                if (index < 0 || index == n || board[index] != next) {
                    index = -1;
                    break;
                }
            }
            res[i] = index;
        }
        return res;
    }
}
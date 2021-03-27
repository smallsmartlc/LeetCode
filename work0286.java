package Leetcode.smart;


/**
 * leetcode 0286 墙与门
 * lintcode 663. 墙和门
 */
public class work0286 {

    public static void main(String[] args) {
        work0286 w = new work0286();
        TreeNode root = new TreeNode(2, 1, 3);
        int[][] rooms = LecoUtil.LecoNewNums(4, 4,
                2147483647, -1, 0, 2147483647, 2147483647, 2147483647, 2147483647, -1, 2147483647, -1, 2147483647, -1, 0, -1, 2147483647, 2147483647);
        LecoUtil.LecoPrint(rooms);
        w.wallsAndGates(rooms);
        LecoUtil.LecoPrint(rooms);
    }

    public void wallsAndGates(int[][] rooms) {
        // write your code here
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j, int step) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < step) return;
        rooms[i][j] = step;
        dfs(rooms, i - 1, j, step + 1);
        dfs(rooms, i, j - 1, step + 1);
        dfs(rooms, i + 1, j, step + 1);
        dfs(rooms, i, j + 1, step + 1);
    }
}


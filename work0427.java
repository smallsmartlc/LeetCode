package Leetcode.smart;

/**
 * 0427 建立四叉树
 */

public class work0427 {
    public static void main(String[] args) {
        work0427 w = new work0427();
        w.run();
    }

    private void run() {
        int[][] grids = LecoUtil.LecoNewNums(8, 8,
                1, 1, 1, 1, 0, 0, 0, 0,
                1, 1, 1, 1, 0, 0, 0, 0,
                1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 0, 0, 0, 0,
                1, 1, 1, 1, 0, 0, 0, 0,
                1, 1, 1, 1, 0, 0, 0, 0,
                1, 1, 1, 1, 0, 0, 0, 0);
        Node construct = construct(grids);
        System.out.println(construct);
    }

    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length);
    }

    private Node dfs(int[][] grid, int row, int col, int length) {
        boolean same = true;
        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                if (grid[row][col] != grid[i][j]) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }
        Node node = new Node(grid[row][col] == 1, same);
        if (same) return node;
        int l = length / 2;
        node.topLeft = dfs(grid, row, col, l);
        node.topRight = dfs(grid, row, col + l, l);
        node.bottomLeft = dfs(grid, row + l, col, l);
        node.bottomRight = dfs(grid, row + l, col + l, l);
        return node;
    }

    private class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

}
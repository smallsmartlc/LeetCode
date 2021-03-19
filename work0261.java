package Leetcode.smart;

import java.util.Arrays;

/**
 * leetcode0261 以图判树
 * lintcode178. 图是否是树
 */
public class work0261 {

    public static void main(String[] args) {

        work0261 w = new work0261();
        int[][] nums = LecoUtil.LecoNewNums(2, 4, 0, 1, 0, 2, 0, 3, 1, 4);
        int[][] nums2 = LecoUtil.LecoNewNums(2, 5, 0, 1, 1, 2, 2, 3, 1, 3, 1, 4);
        System.out.println(w.validTree(5, nums2));
    }
    private boolean[] visit;
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if(edges.length < n-1) return false;
        visit = new boolean[n];
        boolean[][] map = new boolean[n][n];
        for (int[] edge : edges) {
            map[edge[0]][edge[1]] = true;
            map[edge[1]][edge[0]] = true;
        }
        if(!dfs(map,0,-1)){
            return false;
        }
        for (boolean b : visit) {
            if(!b) return false;
        }
        return true;
    }

    private boolean dfs(boolean[][] map, int cur,int parent) {
        if(visit[cur]) return false;
        visit[cur] = true;
        for (int i = 0; i < map[cur].length; i++) {
            if(map[cur][i]){
                if(i != parent && !dfs(map,i,cur)){
                    return false;
                }
            }
        }
        return true;
    }
}


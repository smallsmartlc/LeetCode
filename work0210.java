package Leetcode.smart;


import java.util.*;

public class work0210 {
    public static void main(String[] args) {
        work0210 w = new work0210();
        int[][] nums = LecoUtil.LecoNewNums(2, 2, 1, 0, 0, 1);
        LecoUtil.LecoPrint(w.findOrder(2, nums));
    }


    List<List<Integer>> list = new ArrayList<>();

    int[] visited;
    int[] res;//将数组当栈使用
    int index;
    boolean vaild = false; //判断是否有环

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            list.get(prerequisite[1]).add(prerequisite[0]);
        }
        visited = new int[numCourses];
        res = new int[numCourses];
        index = numCourses - 1;

        for (int i = 0; i < numCourses && (!vaild); i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        if (vaild) {
            return new int[0];
        }

        return res;
    }

    private void dfs(int cur) {

        visited[cur] = 1;//搜索中

        for (Integer son : list.get(cur)) {
            if (visited[son] == 0) {
                dfs(son);
                if (vaild) return;
            } else if (visited[son] == 1) {
                vaild = true;
                return;
            }
        }
        visited[cur] = 2;
        res[index--] = cur;

    }
}
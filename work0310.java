package Leetcode.smart;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class work0310 {
    public static void main(String[] args) {
        work0310 w = new work0310();
        int[][] nums = LecoUtil.LecoNewNums(2, 5, 0, 3, 1, 3, 2, 3, 4, 3, 5, 4);
        System.out.println(w.findMinHeightTrees(6, nums));
    }

    List<List<Integer>> dict = new ArrayList<>();

    public List<Integer> findMinHeightTrees(int n, int[][] edges){
        List<Integer> res = new ArrayList<>();
        if(n==1){
            res.add(0);
            return res;
        }
        for (int i = 0; i < n; i++) {
            dict.add(new ArrayList<>());
        }
        int[] degrees = new int[n];
        for (int[] edge : edges) {
            dict.get(edge[0]).add(edge[1]);
            dict.get(edge[1]).add(edge[0]);
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degrees[i]==1) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                list.add(cur);
                List<Integer> thislist = dict.get(cur);
                for (Integer integer : thislist) {
                    degrees[integer]--;
                    if(degrees[integer] == 1) queue.add(integer);
                }
            }
            res = list;
        }
        return res;
    }

    /**
//    递归查找深度,超时
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            dict.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            dict.get(edge[0]).add(edge[1]);
            dict.get(edge[1]).add(edge[0]);
        }
        int minDepth = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int depth = getDepth(i, -1);
            if (depth < minDepth) {
                minDepth = depth;
                res.clear();
                res.add(i);
            } else if (depth == minDepth) {
                res.add(i);
            }
        }

        return res;
    }

    private int getDepth(int now, int father) {

        List<Integer> sons = dict.get(now);
        int depth = 1;
        int max = 0;
        for (Integer i : sons) {
            if (i == father) continue;
            max = Integer.max(max, getDepth(i, now));
        }
        return depth + max;
    }
     */
}
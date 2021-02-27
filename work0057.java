package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode0057 插入区间
 */
public class work0057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;//记录是否插入了
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                //在右侧且无交集
                if (!placed) {
                    placed = true;
                    list.add(new int[]{left, right});
                }
            } else if (interval[1] < left) {
                //在左侧且无交集
            } else {
                //有重复区间
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
                continue;
            }
            list.add(interval);
        }
        if (!placed) {
            list.add(new int[]{left, right});
        }
//        return list.stream().toArray(int[][]::new); //流式运算好像不太快的样子
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        work0057 w = new work0057();
        int[][] intervals = LecoUtil.LecoNewNums(2, 2, 1, 3, 6, 9);
        int[] newInterval = {2, 5};
        int[][] res = w.insert(intervals, newInterval);
        LecoUtil.LecoPrint(res);
    }
}

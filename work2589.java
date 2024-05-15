package Leetcode.smart;

import java.util.Arrays;
import java.util.Comparator;

/**
 * LeetCode2589 完成所有任务的最少时间
 * @author lucong
 * @date 2024-05-15
 */

public class work2589 {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(o2 -> o2[1]));
        int res = 0;
        boolean[] run = new boolean[tasks[tasks.length-1][1] + 1]; //标记是否使用
        for (int[] task : tasks) {
            int duration = task[2];
            for (int i = task[0]; i <= task[1]; i++) {
                if (run[i]) duration--;
                if (duration == 0) break;
            }
            res += duration;
            for (int i = task[1]; duration > 0 && i >= task[0]; i--) {
                if (!run[i]){
                    duration--;
                    run[i] = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        work2589 w = new work2589();
        int[][] nums = LecoUtil.LecoNewNums(3, 3, 1, 3, 2, 2, 5, 3, 5, 6, 2);
        System.out.println(w.findMinimumTime(nums));
    }
}

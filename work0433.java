package Leetcode.smart;

import java.util.*;

/**
 * 0433 最小基因变化
 */

public class work0433 {
    public static void main(String[] args) {
        work0433 w = new work0433();
        w.minMutation("AACCGGTT", "AACCGGTA", "AACCGGTA");
    }

    public int minMutation(String start, String end, String... bank) {
        if (start.equals(end)) return 0;
        char[] genes = {'A', 'T', 'C', 'G'};
        HashSet<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();// 优化查找过的数组
        for (String s : bank) {
            set.add(s);
        }
        if (!set.contains(end)) return -1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                StringBuilder sb = new StringBuilder(cur);
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (genes[j] == cur.charAt(i)) continue;
                        sb.setCharAt(i, genes[j]);
                        String next = sb.toString();
                        if (next.equals(end)) return step;
                        if (visited.contains(next) || !set.contains(next)) continue;
                        visited.add(next);
                        queue.offer(next);
                    }
                    sb.setCharAt(i, cur.charAt(i));
                }
            }
            step++;
        }
        return -1;
    }
}
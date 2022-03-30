package Leetcode.smart;

//1606 找到处理最多请求的服务器

import java.util.*;

public class work1606 {
    public static void main(String[] args) {
        work1606 w = new work1606();
        System.out.println(w.busiestServers(3, new int[]{1, 2, 3, 4, 5}, new int[]{5, 2, 3, 3, 3}));
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        TreeSet<Integer> set = new TreeSet<>(); //空闲的服务器
        for (int i = 0; i < k; i++) {
            set.add(i);
        }
        int[] handles = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[1] <= arrival[i]) {
                set.add(busy.poll()[0]);
            }
            if (set.isEmpty()) continue;
            Integer cur = set.ceiling(i % k);
            if (cur == null) cur = set.first();
            set.remove(cur);
            handles[cur]++;
            busy.offer(new int[]{cur, arrival[i] + load[i]});
        }
        List<Integer> res = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < handles.length; i++) {
            if (handles[i] == max) {
                res.add(i);
            } else if (handles[i] > max) {
                max = handles[i];
                res.clear();
                res.add(i);
            }
        }
        return res;
    }

}
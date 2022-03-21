package Leetcode.smart;

import java.util.*;

/**
 * 2039 网络空闲的时刻
 *
 * @author LuCong
 * @since 2022-3-20
 **/
public class work2039 {
    public static void main(String[] args) {
        work2039 w = new work2039();
        int[][] edges = LecoUtil.LecoNewNums(2, 15,
                3, 8, 4, 13, 0, 7, 0, 4, 1, 8, 14, 1, 7, 2, 13, 10, 9, 11, 12, 14, 0, 6, 2, 12, 11, 5, 6, 9, 10, 3);
        int[] patience = new int[]{0, 3, 2, 1, 5, 1, 5, 5, 3, 1, 2, 2, 2, 2, 1};
        System.out.println(w.networkBecomesIdle1(edges, patience));
    }

    public int networkBecomesIdle1(int[][] edges, int[] patience) {
        // 迪杰特斯拉
        int n = patience.length;
        Map<Integer, Integer>[] map = new Map[n];
        for (int i = 0; i < map.length; i++) {
            map[i] = new HashMap<>();
        }
        for (int[] edge : edges) {
            map[edge[0]].put(edge[1], 1);
            map[edge[1]].put(edge[0], 1);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Integer poll = queue.poll();
                if (dis[poll] == Integer.MAX_VALUE) continue;
                for (Map.Entry<Integer, Integer> entry : map[poll].entrySet()) {
                    Integer i = entry.getKey();
                    if (visited[i]) continue;
                    visited[i] = true;
                    queue.offer(i);
                    int distance = dis[poll] + map[poll].get(i);
                    if (distance < dis[i]) {
                        dis[i] = distance;
                    }
                }
            }
        }
        LecoUtil.LecoPrint(dis);
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            int num = (dis[i] * 2 - 1) / patience[i];
            int rest = num * patience[i];
            ans = Math.max(ans, rest + dis[i] * 2);
        }
        return ans + 1;
    }

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<Integer>[] map = new List[n];
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int ans = 0;
        int dist = 1;
        boolean[] visit = new boolean[n];
        visit[0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Integer poll = queue.poll();
                for (int i : map[poll]) {
                    if (visit[i]) {
                        continue;
                    }
                    queue.offer(i);
                    int time = patience[i] * ((2 * dist - 1) / patience[i]) + 2 * dist + 1;
                    ans = Math.max(ans, time);
                    visit[i] = true;
                }
            }
            dist++;
        }
        return ans;
    }

}



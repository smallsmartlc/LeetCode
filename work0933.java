package Leetcode.smart;

import java.util.*;

/**
 * 0933 最近的请求次数
 */
public class work0933 {

    public static void main(String[] args) {
        work0933 w = new work0933();
        w.run();
    }

    private void run() {
        RecentCounter obj = new RecentCounter();
        System.out.println(obj.ping(1));
    }

    private class RecentCounter0 {

        // 使用TreeSet,沒有利用到ping参数越来越大的性质
        private TreeSet<Integer> set;

        public RecentCounter0() {
            set = new TreeSet<>();
        }

        public int ping(int t) {
            set.add(t);
            return set.tailSet(t - 3000).size();
        }
    }

    private class RecentCounter {

        private Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.offer(t);
            while (queue.peek() < t - 3000) queue.poll();
            return queue.size();
        }
    }
}

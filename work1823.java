package Leetcode.smart;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1823 找出游戏的获胜者
 *
 * @author LuCong
 * @since 2022-5-4
 **/
public class work1823 {
    public static void main(String[] args) {
        work1823 w = new work1823();
        System.out.println(w.findTheWinner(8, 8));
    }

    public int findTheWinner(int n, int k) {
        boolean[] live = new boolean[n];
        int start = 0;
        for (int i = 0; i < n - 1; i++) {
            int count = 0;
            for (int j = count; count < k; j++) {
                if (live[(start + j) % n]) continue;
                count++;
                if (count == k) {
                    live[(start + j) % n] = true;
                    start = (start + j + 1) % n;
                }
            }
        }
        for (int i = 0; i < live.length; i++) {
            if (!live[i]) return i + 1;
        }
        return -1;
    }

    public int findTheWinner2(int n, int k) {
        // 队列
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.peek();
    }

    public int findTheWinner3(int n, int k) {
        // 数学
        if (n == 1) {
            return 1;
        }
        return (k + findTheWinner3(n - 1, k) - 1) % n + 1;
    }
}








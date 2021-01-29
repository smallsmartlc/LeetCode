package Leetcode.smart;

import java.util.*;

/**
 * 0278.第一个错误的版本
 */
public class work0279 {

    public static void main(String[] args) {

        work0279 w = new work0279();
        System.out.println(w.numSquares(144));
    }

    public int numSquares(int n) {
        //贪心+bfs
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }
        Set<Integer> queue = new HashSet<>();
        queue.add(n);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            Set<Integer> set = new HashSet<>();
            for (Integer q : queue) {
                for (Integer square : squares) {
                    if (q.equals(square)) {
                        return level;
                    }
                    if (q < square) {
                        break;
                    }
                    set.add(q - square);
                }
            }
            queue = set;
        }
        return level;
    }

    public int numSquares3(int n) {
        // 贪心
        for (int i = 0; i * i <= n; i++) {
            squares.add(i * i);
        }
        int count = 1;
        while (count <= n) {
            if (isDividedBy(n, count)) {
                return count;
            }
            count++;
        }
        return count;
    }

    Set<Integer> squares = new HashSet<>();

    private boolean isDividedBy(int n, int count) {
        if (count == 1) {
            return squares.contains(n);
        }
        for (Integer square : squares) {
            if (n < square) continue;
            if (isDividedBy(n - square, count - 1)) {
                return true;
            }
        }
        return false;
    }

    public int numSquares2(int n) {
        //动态规划
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int[] temp = new int[(int) Math.sqrt(n) + 1];
        for (int i = 1; i < temp.length; i++) {
            temp[i] = i * i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < temp.length && temp[j] <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - temp[j]] + 1);
            }
        }
        return dp[n];
    }


    public int numSquares1(int n) {
        dfs(n, 0);
        return res;
    }

    // 回溯法,行!
    private int res = Integer.MAX_VALUE;

    private void dfs(int n, int num) {
        if (num > res) return;
        if (n == 0) {
            res = num;
            return;
        }
        for (int i = 1; i * i <= n; i++) {
            dfs(n - i * i, num + 1);
        }
    }

}


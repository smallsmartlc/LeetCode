package Leetcode.smart;

/**
 * LeetCode0746 使用最小花费爬楼梯
 */

public class work0746 {
    public static void main(String[] args) {
        work0746 w = new work0746();
        System.out.println(w.minCostClimbingStairs(new int[]{10, 15, 20}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int i = 0; // 第一个台阶的花费
        int j = 0; // 第二个台阶的花费
        for (int k = 2; k < cost.length + 1; k++) {
            int temp = Math.min(i + cost[k - 2], j + cost[k - 1]);
            i = j;
            j = temp;
        }
        return j;
    }

}
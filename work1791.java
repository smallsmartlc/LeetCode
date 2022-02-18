package Leetcode.smart;

//LeetCode1791 找出星型图的中心节点

public class work1791 {
    public static void main(String[] args) {
        work1791 w = new work1791();
    }

    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] nums = new int[n + 1];
        for (int[] edge : edges) {
            nums[edge[0]]++;
            nums[edge[1]]++;
            if (nums[edge[0]] > 1) return nums[edge[0]];
            if (nums[edge[1]] > 1) return nums[edge[1]];
        }
        return -1;
    }

    public int findCenter2(int[][] edges) {
        // 只看前两条边
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
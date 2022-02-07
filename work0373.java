package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


/**
 * LeetCode0373 查找和最小的 K 对数字
 */
public class work0373 {
    public static void main(String[] args) {
        work0373 w = new work0373();
        System.out.println(w.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10));
    }

    public List<List<Integer>> kSmallestPairs0(int[] nums1, int[] nums2, int k) {
        // 暴力法
        int n = nums1.length;
        int m = nums2.length;
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.get(0) + o1.get(1) - o2.get(0) - o2.get(1));
        for (int i = 0; i < Math.min(n, k); i++) {
            for (int j = 0; j < Math.min(m, k); j++) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                queue.add(list);
            }
        }
        while (!queue.isEmpty() && res.size() < k){
            res.add(queue.poll());
        }
        return res;
    }


    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        // 优先队列里存储的是下标
        for (int i = 0; i < Math.min(n, k); i++) { // 先将一列坐标加入,然后从这些坐标向右找
            queue.offer(new int[]{i,0}); // {i,j} 肯定小于{i,0},所以我们在{i,0}被取到后将{i,1}加入堆即可
        }
        while (!queue.isEmpty() && res.size() < k){
            int[] poll = queue.poll();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums1[poll[0]]);
            list.add(nums2[poll[1]]);
            res.add(list);
            if(poll[1] + 1 < m){
                queue.offer(new int[]{poll[0],poll[1]+1});
            }
        }
        return res;
    }
}
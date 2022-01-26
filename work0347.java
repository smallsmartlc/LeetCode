package Leetcode.smart;

//346. 前 K 个高频元素

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class work0347 {
    public static void main(String[] args) {
        work0347 w = new work0347();
        LecoUtil.LecoPrint(w.topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair> prior = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(prior.size() == k){
                if(prior.peek().v < value){
                    prior.poll();
                    prior.offer(new Pair(key,value));
                }
            }else{
                prior.offer(new Pair(key,value));
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = prior.poll().k;
        }
        return res;
    }
    private static class Pair implements Comparable<Pair>{
        Integer k;
        Integer v;
        public Pair(Integer k, Integer v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public int compareTo(Pair o) {
            return this.v-o.v;
        }
    }
}
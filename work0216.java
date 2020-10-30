package Leetcode.smart;

//216. 组合总和 III

import java.util.ArrayList;
import java.util.List;

public class work0216 {
    public static void main(String[] args) {
        work0216 w = new work0216();
        System.out.println(w.combinationSum3(3, 9));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, new ArrayList<>(), 0, 0);
        return res;
    }

    private void dfs(int k, int n, List<Integer> list, int start, int sum) {
        if (list.size() >= k || sum >= n) {
            if (list.size() == k && sum == n) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start + 1; i < 10; i++) {
            if (i > n - k + 1) break;
            list.add(i);
            sum += i;
            dfs(k,n,list,i,sum);
            sum-=i;
            list.remove(list.size()-1);
        }
    }

    private List<List<Integer>> res = new ArrayList<>();

}
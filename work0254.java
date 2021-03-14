package Leetcode.smart;


import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 252. 因子的组合
 * lintcode 1308. 因子组合
 */
public class work0254 {

    public static void main(String[] args) {
        work0254 w = new work0254();
        System.out.println(w.getFactors(12));
    }

    public List<List<Integer>> getFactors(int n) {
        // write your code here
        return dfs(n,2);
    }
    private List<List<Integer>> dfs(int n,int start){
        List<List<Integer>> res = new ArrayList<>();
        for (int i = start; i*i <= n; i++) {
           if(n%i == 0){
               res.add(new ArrayList<>(List.of(n/i,i)));
               List<List<Integer>> dfs = dfs(n / i, i);
               for (List<Integer> df : dfs) {
                   df.add(i);
                   res.add(df);
               }
           }
        }
        return res;
    }

}


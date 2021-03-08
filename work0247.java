package Leetcode.smart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode0247	中心对称数 II (会员)
 * LintCode0776 对称数 II
 */
public class work0247 {
    public static void main(String[] args) {
        work0247 w = new work0247();
        System.out.println(w.findStrobogrammatic(3));
    }

    private int n;
    public List<String> findStrobogrammatic(int n) {
        // write your code here
        this.n = n;
        return dfs(n);
    }

    private List<String> dfs(int n) {
        if(n == 0) return new ArrayList<>(Arrays.asList(""));
        if(n == 1) return new ArrayList<>(Arrays.asList("0","1","8"));
        List<String> dfs = dfs(n - 2);
        ArrayList<String> res = new ArrayList<>();
        for (String s : dfs) {
            if(n!=this.n){
                res.add('0'+s+'0');
            }
            res.add('1'+s+'1');
            res.add('6'+s+'9');
            res.add('8'+s+'8');
            res.add('9'+s+'6');
        }
        return res;
    }
}

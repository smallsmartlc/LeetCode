package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode0386 字典序排数
 */
public class work0386 {
    public static void main(String[] args) {
        work0386 w = new work0386();
        System.out.println(w.lexicalOrder(120));
        System.out.println(w.lexicalOrder2(120));
    }

    List<Integer> res;

    public List<Integer> lexicalOrder(int n) {
        // 递归,额外栈空间
        res = new ArrayList<>(n);
        dfs(n, 0);
        return res;
    }

    private void dfs(int n, int pre) {
        for (int i = 0; i < 10; i++) {
            if (pre == 0 && i == 0) continue;
            int num = pre * 10 + i;
            if (num > n) break;
            res.add(num);
            dfs(n, num);
        }
    }

    public List<Integer> lexicalOrder2(int n) {
        res = new ArrayList<>(n);
        int num = 1;
        while (res.size() < n) {
            while (num <= n) {
                res.add(num);
                num *= 10;
            }
            while (num % 10 == 9 || num > n) {
                num /= 10; // 返回上一层
            }
            num++; // 自加
        }
        return res;
    }
}
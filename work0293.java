package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode0293 翻转游戏  (会员)
 * LintCode0914 翻转游戏
 */
public class work0293 {
    public static void main(String[] args) {
        work0293 w = new work0293();
        System.out.println(w.generatePossibleNextMoves("---+++-+++-+"));
    }

    public List<String> generatePossibleNextMoves(String s) {
        // write your code here
        List<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length-1; i++) {
            if(chars[i] == '+' && chars[i+1] == '+'){
                chars[i] = '-';
                chars[i+1] = '-';
                res.add(new String(chars));
                chars[i] = '+';
                chars[i+1] = '+';
            }
        }
        return res;
    }
}

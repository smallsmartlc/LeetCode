package Leetcode.smart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode0293 翻转游戏 II  (会员)
 * LintCode0913 翻转游戏II
 */
public class work0294 {
    public static void main(String[] args) {
        work0294 w = new work0294();
        System.out.println(w.canWin("---+++-+++-+"));
    }

    private Map<String, Boolean> map = new HashMap<>();

    public boolean canWin(String s) {
        // write your code here
        if (s.length() < 2) return false;
        if (map.get(s) != null) return map.get(s);
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {
            if (ch[i] == '+' && ch[i + 1] == '+') {
                ch[i] = '-';
                ch[i + 1] = '-';
                if (!canWin(new String(ch))) {
                    map.put(s, true);
                    return true;
                }
                ch[i] = '+';
                ch[i + 1] = '+';
            }
        }
        map.put(s, false);
        return false;
    }
}

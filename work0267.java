package Leetcode.smart;


import java.util.*;

/**
 * leetcode 2667 回文排列 II
 * lintcode 917. 回文排列 II
 */
public class work0267 {

    public static void main(String[] args) {
        work0267 w = new work0267();
        System.out.println(w.generatePalindromes("aabb"));
    }

    private List<String> res = new ArrayList<>();
    private int n;

    public List<String> generatePalindromes(String s) {
        // write your code here
        n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        if (set.size() > 1) return res;
        String temp = "";
        if (set.size() == 1) {
            Character c = set.iterator().next();
            temp += c;
            map.put(c, map.get(c) - 1);
        }
        dfs(map, temp);
        return res;
    }

    private void dfs(Map<Character, Integer> map, String s) {
        if (s.length() == n) {
            res.add(s);
            return;
        }
        for (Character key : map.keySet()) {
            int p;
            if ((p = map.get(key)) > 1) {
                map.put(key, p - 2);
                dfs(map, key + s + key);
                map.put(key, p);
            }
        }
    }
}


package Leetcode.smart;

import java.util.*;

/**
 * LeetCode140. 单词拆分 II
 */

public class work0140 {
    private HashSet<String> dict = new HashSet<>();
    private Map<Integer, List<String>> map = new HashMap<>(); //记忆化搜索

    public List<String> wordBreak(String s, List<String> wordDict) {
        // 回溯法 记忆化递归
        dict.addAll(wordDict);
        return dfs(s, 0);
    }

    private List<String> dfs(String s, int start) {
        if (start == s.length()) {
            return null;
        }
        if (!map.containsKey(start)) {
            List<String> sentences = new ArrayList<>();
            for (int end = start + 1; end <= s.length(); end++) {
                StringBuilder str = new StringBuilder(s.substring(start, end));
                if (dict.contains(str.toString())) {
                    List<String> sentence = dfs(s, end);
                    if (sentence == null) {
                        sentences.add(str.toString());
                    } else {
                        for (String s1 : sentence) {
                            sentences.add(new StringBuilder(str).append(" ").append(s1).toString());
                        }
                    }
                }
            }
            map.put(start, sentences);
        }
        return map.get(start);
    }

    public static void main(String[] args) {
        work0140 w = new work0140();
        String[] s = new String[]{"apple", "pen", "applepen", "pine", "pineapple"};
        System.out.println(w.wordBreak("pineapplepenapple"
                , new ArrayList<>(Arrays.asList(s))));
    }
}

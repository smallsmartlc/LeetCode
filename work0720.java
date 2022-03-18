package Leetcode.smart;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 0720 词典中最长的单词
 */

public class work0720 {
    public static void main(String[] args) {
        work0720 w = new work0720();
        System.out.println(w.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
    }

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        String longest = "";
        for (String word : words) {
            if (trie.search(word)) {
                if (word.length() > longest.length() || (word.length() == longest.length() && word.compareTo(longest) < 0)) {
                    longest = word;
                }
            }
        }
        return longest;
    }

    private class Trie {
        Trie[] child;
        boolean isEnd;

        public Trie() {
            child = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                if (node.child[c - 'a'] == null) {
                    node.child[c - 'a'] = new Trie();
                }
                node = node.child[c - 'a'];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                if (node.child[c - 'a'] == null || !node.child[c - 'a'].isEnd) return false;
                node = node.child[c - 'a'];
            }
            return node != null && node.isEnd;
        }
    }

    public String longestWord0(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return b.compareTo(a);
            }
        });
        HashSet<String> set = new HashSet<>();
        String ans = "";
        set.add(ans);
        for (String word : words) {
            if (set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                ans = word;
            }
        }
        return ans;
    }
}
package Leetcode.smart;

/**
 * LeetCode0243 最短单词距离  (会员)
 * LintCode0924 单词最短距离
 */
public class work0243 {
    public static void main(String[] args) {
        work0243 w = new work0243();
        System.out.println(w.shortestDistance(
                new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "makes", "coding"));
    }

    public int shortestDistance(String[] words, String word1, String word2) {
        // Write your code here
        int index1 = -1;
        int index2 = -1;
        int res = words.length;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                index1 = i;
                if (index2 != -1) res = Math.min(res, index1 - index2);
            }else if (word2.equals(words[i])) {
                index2 = i;
                if (index1 != -1) res = Math.min(res, index2 - index1);
            }
        }
        return res;
    }
}

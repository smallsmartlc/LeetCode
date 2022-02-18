package Leetcode.smart;

/**
 * LeetCode0392 判断子序列
 */
public class work0392 {
    public static void main(String[] args) {
        work0392 w = new work0392();
        System.out.println(w.isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence2(String s, String t) {
        // 动态规划,预处理t
        int n = t.length();
        int[][] dp = new int[n + 1][26]; // 表示某个位置往后每一个字符第一次出现的位置
        for (int i = n - 1; i >= 0; i--) {
            int letter = t.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                if (letter == j) {
                    dp[i][j] = i + 1; //用0表示后面没有了,所以dp中存储的下标都+1避开0
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        int i = 0;
        for (char c : s.toCharArray()) {
            if (dp[i][c - 'a'] == 0) return false;
            i = dp[i][c - 'a'];
        }
        return true;
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (char c : t.toCharArray()) {
            if (i == s.length()) return true;
            if (s.charAt(i) == c) i++;
        }
        return i == s.length();
    }
}
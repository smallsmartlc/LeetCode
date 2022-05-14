package Leetcode.smart;

import java.util.Arrays;

/**
 * 0691 贴纸拼词
 */

public class work0691 {
    public static void main(String[] args) {
        work0691 w = new work0691();
        System.out.println(w.minStickers(new String[]{"with", "example", "science"}, "thehat"));

    }

    public int minStickers(String[] stickers, String target) {
        int n = target.length();
        int[] dp = new int[1 << n]; // 用二进制表示target的每一个字母是否使用时的数量
        Arrays.fill(dp, -1);
        dp[0] = 0; // target所有字符都不使用
        int ans = dfs(stickers, target, dp, (1 << n) - 1);
        return ans > n ? -1 : ans;
    }

    private int dfs(String[] stickers, String target, int[] dp, int mask) {
        int n = target.length();
        if (dp[mask] > -1) return dp[mask];
        dp[mask] = n + 1;
        for (String sticker : stickers) {
            int[] cnt = new int[26];
            for (char c : sticker.toCharArray()) {
                cnt[c - 'a']++;
            }
            int temp = mask; // 快照
            for (int i = 0; i < n; i++) {
                char c = target.charAt(i);
                if ((temp & (1 << i)) > 0 && cnt[c - 'a'] > 0) {
                    cnt[c - 'a']--;
                    temp ^= (1 << i);
                }
            }
            if (temp < mask) {
                dp[mask] = Math.min(dp[mask], dfs(stickers, target, dp, temp) + 1); // temp == mask 说明这个单词没用
            }
        }
        return dp[mask];
    }
}
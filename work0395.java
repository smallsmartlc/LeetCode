package Leetcode.smart;

import java.util.Arrays;

/**
 * LeetCode0395 至少有 K 个重复字符的最长子串
 */
public class work0395 {
    public static void main(String[] args) {
        work0395 w = new work0395();
//        System.out.println(w.longestSubstring("aaabbb", 3));
//        System.out.println(w.longestSubstring("ababacb", 3));
        System.out.println(w.longestSubstring2("bchhbbdefghiaaacb", 3));

    }

    public int longestSubstring2(String s, int k) {
        // 滑动窗口
        int res = 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        int total = 0;
        int[] map = new int[26];
        for (char c : chars) {
            if (map[c - 'a']++ == 0) total++;
        }
        for (int t = 1; t <= total; t++) { // t代表答案中出现的字符种数
            int less = 0; //代表出现了但是不满足条件的数字数量,如果不等于0说明不行
            Arrays.fill(map, 0);
            int l = 0, r = 0;// 双指针
            int thisTotal = 0; // 子串内字符数量
            while (r < n) {
                int times = ++map[chars[r] - 'a'];
                if (times == 1) {
                    thisTotal++;
                    less++;
                }
                if (times == k) {
                    less--;
                }
                while (thisTotal > t) {
                    --map[chars[l] - 'a'];
                    if (map[chars[l] - 'a'] == k - 1) less++;
                    if (map[chars[l] - 'a'] == 0) {
                        less--;
                        thisTotal--;
                    }
                    l++;// 缩小子串确保子串中的字符数量等于可能的字符数量
                }
                if (less == 0) { //thisTotal == t
                    res = Math.max(res, r - l + 1);
                }
                r++; // 扩大子串范围
            }
        }
        return res;
    }

    public int longestSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        return dfs(chars, k, 0, chars.length - 1);
    }

    private int dfs(char[] chars, int k, int l, int r) {
        if (r - l + 1 < k) return 0;
        int[] map = new int[26];
        for (int i = l; i <= r; i++) {
            map[chars[i] - 'a']++;
        }
        int res = 0;
        int pre = -1; // 上一个不满足字符出现的位置
        for (int now = l; now <= r; now++) {
            if (map[chars[now] - 'a'] < k) {
                int length = dfs(chars, k, pre + 1, now - 1);
                res = Math.max(res, length);
                pre = now;
            }
        }
        if (pre == -1) return r - l + 1;
        if (map[chars[r] - 'a'] >= k) res = Math.max(res, dfs(chars, k, pre + 1, r));
        return res;
    }
}
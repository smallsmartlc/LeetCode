package Leetcode.smart;

import java.util.*;

/**
 * LeetCode0387 字符串中的第一个唯一字符
 */
public class work0387 {
    public static void main(String[] args) {
        work0387 w = new work0387();
        System.out.println(w.firstUniqChar("leetcode"));
        System.out.println(w.firstUniqChar4("leetcode"));
        System.out.println(w.firstUniqChar("loveleetcode"));
        System.out.println(w.firstUniqChar4("loveleetcode"));
        System.out.println(w.firstUniqChar("dddccdbba"));
        System.out.println(w.firstUniqChar4("dddccdbba"));
    }

    public int firstUniqChar4(String s) {
        int n = s.length();
        int[] map = new int[26]; //存储下标,0表示未出现,-1表示出现了两次以上,1-n表示只出现了一次的数的下标
        char[] chars = s.toCharArray(); // 全部入列的队列
        int head = 0; // 队列头
        for (int i = 0; i < n; i++) {
            int letter = chars[i] - 'a';
            if (map[letter] == 0) { // 表示未出现
                map[letter] = i + 1; // +1 避免和默认值0重复
            } else if (map[letter] != -1) {
                map[letter] = -1;// 出现了两次
            }
            while (head < n && map[chars[head] - 'a'] == -1) {
                head++;
            }
        }
        return head >= n ? -1 : map[chars[head] - 'a'] - 1; // -1返回真实下标
    }

    public int firstUniqChar3(String s) {
        int res;
        for (char c : s.toCharArray()) {
            if ((res = s.indexOf(c)) == s.lastIndexOf(c)) return res;
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        int n = s.length();
        int[] map = new int[26];
        Queue<int[]> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int letter = s.charAt(i) - 'a';
            if (map[letter] == 0) {
                map[letter]++;
                list.offer(new int[]{letter, i});
            } else if (map[letter] == 1) {
                map[letter]++;// 出现了两次
                while (!list.isEmpty() && map[list.peek()[0]] > 1) {
                    list.poll();
                }
            }
        }
        return list.isEmpty() ? -1 : list.peek()[1];
    }

    public int firstUniqChar(String s) {
        int[] map = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int letter = s.charAt(i) - 'a';
            if (map[letter] == 0) {
                map[letter] = i + 1; // 避免下标和默认值0重复
            } else {
                map[letter] = -1;
            }
        }
        int res = n;
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) { // 出现且仅出现一次
                res = Math.min(res, map[i] - 1);
            }
        }
        return res < n ? res : -1;
    }
}
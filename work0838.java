package Leetcode.smart;

/**
 * LeetCode0838 推多米诺
 */

public class work0838 {
    public static void main(String[] args) {
        work0838 w = new work0838();
//        System.out.println(w.pushDominoes("RR.L"));
        System.out.println(w.pushDominoes(".L.R...LR..L.."));
    }

    public String pushDominoes(String dominoes) {
        char[] s = dominoes.toCharArray();
        int n = s.length;
        int l = 0;
        while (l < n) {
            int r = l;
            while (r < n && s[r] == '.') {
                r++;
            }
            if (r == n || s[r] == 'R') {
                if (l > 0 && s[l - 1] == 'R') {
                    while (l < r) {
                        s[l++] = 'R';
                    }
                }
            } else {
                int k = r - 1;
                if (l > 0 && s[l - 1] == 'R') {
                    while (l < k) {
                        s[l++] = 'R';
                        s[k--] = 'L';
                    }
                } else {
                    while (l <= k) {
                        s[k--] = 'L';
                    }
                }
            }
            l = r + 1;
        }
        return new String(s);
    }
}
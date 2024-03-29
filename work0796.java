package Leetcode.smart;

/**
 * 0796 旋转字符串
 */

public class work0796 {
    public static void main(String[] args) {
        work0796 w = new work0796();
        System.out.println(w.rotateString("abced", "cedab"));
    }

    public boolean rotateString1(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        int n = goal.length();
        for (int offset = 0; offset < n; offset++) {
            for (int i = 0; i < n; i++) {
                if (s.charAt((offset + i) % n) != goal.charAt(i)) break;
                if (i == n - 1) return true;
            }
        }
        return false;
    }
}
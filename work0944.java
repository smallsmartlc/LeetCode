package Leetcode.smart;

/**
 * 0944 删列造序
 */

public class work0944 {
    public static void main(String[] args) {
        work0944 w = new work0944();
        System.out.println(w.minDeletionSize("abc", "bce", "cae"));
    }

    public int minDeletionSize(String... strs) {
        int res = 0;
        int len = strs[0].length();
        for (int i = 0; i < len; i++) {
            int pre = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                char c = strs[j].charAt(i);
                if (c < pre) {
                    res++;
                    break;
                }
                pre = c;
            }
        }
        return res;
    }
}
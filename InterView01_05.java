package Leetcode.smart;
// 面试题 01.05. 一次编辑
public class InterView01_05 {

    public static void main(String[] args) {
        InterView01_05 w = new InterView01_05();
        System.out.println(w.oneEditAway("pale", "ple"));
    }

    public boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            int num = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) num++;
                if (num > 1) return false;
            }
            return true;
        }
        if (first.length() < second.length()) {
            String temp = second;
            second = first;
            first = temp;
        }
        if (first.length() - second.length() > 1) return false;
        int n = first.length();
        int num = 0; // 错误的个数
        for (int i = 0; i < n; i++) {
            if (i == n - 1 && num < 1) return true;
            if (first.charAt(i) != second.charAt(i - num)) {
                num++;
                if (num > 1) return false;
            }
        }
        return true;
    }
}

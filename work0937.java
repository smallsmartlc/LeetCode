package Leetcode.smart;

import java.util.Arrays;

/**
 * 0937 重新排列日志文件
 */
public class work0937 {

    public static void main(String[] args) {
        work0937 w = new work0937();
        LecoUtil.LecoPrint(w.reorderLogFiles(new String[]{
                "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"
        }));
    }

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2) -> {
            String[] s1 = o1.split(" ", 2);
            String[] s2 = o2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(s2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int i = s1[1].compareTo(s2[1]);
                if (i == 0) return s1[0].compareTo(s2[0]);
                return i;
            } else return isDigit1 ? isDigit2 ? 0 : 1 : -1;
        });
        return logs;
    }

}

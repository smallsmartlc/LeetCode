package Leetcode.smart;

import java.util.HashSet;
import java.util.Set;

/**
 * 0804 推多米诺
 */

public class work0804 {
    public static void main(String[] args) {
        work0804 w = new work0804();
        System.out.println(w.uniqueMorseRepresentations("gin", "zen", "gig", "msg"));
    }

    private String[] mosCode = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String... words) {
        Set<String> set = new HashSet<>();
        for (String w : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : w.toCharArray()) {
                sb.append(mosCode[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
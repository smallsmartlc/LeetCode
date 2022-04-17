package Leetcode.smart;


import java.util.HashMap;
import java.util.HashSet;

/**
 * 0819 最常见的单词
 */

public class work0819 {
    public static void main(String[] args) {
        work0819 w = new work0819();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        System.out.println(w.mostCommonWord(paragraph, new String[]{"hit"}));
    }

    /**
     * 正则表达式可以使用\W+
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : banned) {
            set.add(s);
        }
        int max = 0;
        String maxStr = null;
        StringBuilder sb = new StringBuilder();
        paragraph += " ";
        for (char c : paragraph.toCharArray()) {
            if (!Character.isLetter(c)) {
                if (sb.length() < 1) continue;
                String key = sb.toString();
                sb.setLength(0);
                if (set.contains(key)) continue;
                int times = map.getOrDefault(key, 0) + 1;
                map.put(key, times);
                if (times > max) {
                    maxStr = key;
                    max = times;
                }
                continue;
            }
            if (Character.isUpperCase(c)) c = Character.toLowerCase(c);
            sb.append(c);
        }
        return maxStr;
    }

}
package Leetcode.smart;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * leetcode 0291. 单词规律 II
 * lintcode 829 · 字模式 II
 */
public class work0291 {

    public static void main(String[] args) {

        work0291 w = new work0291();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        System.out.println(w.wordPatternMatch("abab", "redblueredblue"));
    }

    public boolean wordPatternMatch(String pattern, String str) {
        // write your code here
        if (pattern.length() == 0) {
            return str.length() == 0;
        }
        char letter = pattern.charAt(0);
        for (int i = 1; i <= str.length() - pattern.length() + 1; i++) {
            String substr = str.substring(0, i);
            String mapstr = map.get(letter);
            if ((mapstr != null && substr.equals(mapstr)) || (mapstr == null && !map.containsValue(substr))){
                map.put(letter,substr);
                if(wordPatternMatch(pattern.substring(1),str.substring(i))){
                    return true;
                }else if(mapstr == null){
                    map.remove(letter);
                }
            }
        }
        return false;
    }

    private HashMap<Character, String> map = new HashMap<>();

}


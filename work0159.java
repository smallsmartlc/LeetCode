package Leetcode.smart;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode0159 至多包含两个不同字符的最长子串(会员)
 * LintCode0928 最多有两个不同字符的最长子串
 */

public class work0159 {
    public static void main(String[] args) {
        work0159 w = new work0159();
        System.out.println(w.lengthOfLongestSubstringTwoDistinct("bacbbcabcabbcc"));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // Write your code here
        char[] chars = s.toCharArray();
        int n = chars.length;
        if (n < 3) return n;
        int left = 0;
        int right = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < n) {
            map.put(chars[right], right);
            right++;
            if(map.size() > 2){
                Integer minIndex = Collections.min(map.values());
                map.remove(chars[minIndex]);
                left = minIndex + 1;
            }
            res = Math.max(res,right - left);
        }
        return res;
    }
}

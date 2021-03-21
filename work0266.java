package Leetcode.smart;


import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 266. 回文排列
 * lintcode 916. 回文排列
 */
public class work0266 {

    public static void main(String[] args) {
        work0266 w = new work0266();
        System.out.println(w.canPermutePalindrome(""));
    }
    public boolean canPermutePalindrome(String s) {
        // write your code here
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if(set.contains(c)){
                set.remove(c);
            }else {
                set.add(c);
            }
        }
        return set.size() < 2;
    }
}


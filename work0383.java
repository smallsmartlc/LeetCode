package Leetcode.smart;


/**
 * LeetCode0383 赎金信
 */
public class work0383 {
    public static void main(String[] args) {
        work0383 w = new work0383();
        System.out.println(w.canConstruct("aa","aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (char c : magazine.toCharArray()) {
            map[c-'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if(map[c-'a']-- < 1) return false;
        }
        return true;
    }
}
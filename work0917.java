package Leetcode.smart;

/**
 * LeetCode0917 仅仅反转字母
 */

public class work0917 {
    public static void main(String[] args) {
        work0917 w = new work0917();
        System.out.println(w.reverseOnlyLetters("ab-cd"));
    }

    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            while (!Character.isLetter(chars[i])) {
                i++;
            }
            while (!Character.isLetter(chars[j])) {
                j--;
            }
            if (i < j) swap(chars, i, j);
            j--;
            i++;
        }
        return new String(chars);
    }

    private void swap(char[] c, int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }

}
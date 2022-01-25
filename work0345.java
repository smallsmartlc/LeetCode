package Leetcode.smart;

//345. 反转字符串中的元音字母

import java.util.HashSet;

public class work0345 {
    public static void main(String[] args) {
        work0345 w = new work0345();
        System.out.println(w.reverseVowels("hello"));
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (left < right && !isVowel(chars[left])) {
                left++;
            }
            while (left < right &&!isVowel(chars[right])) {
                right--;
            }
            if(left < right) {
                swap(chars, left, right);
                left++;
                right--;
            }
        }
        return new String(chars);
    }
    private boolean isVowel(char c){
//        return "aeiouAEIOU".indexOf(c) > -1;
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
    }
    private void swap(char[] c,int i,int j){
        char temp = c[j];
        c[j] = c[i];
        c[i] = temp;
    }
}
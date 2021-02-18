package Leetcode.smart;

/**
 * LeetCode0316 去除重复字母
 */

public class work0316 {
    public static void main(String[] args) {
        work0316 w = new work0316();
        System.out.println(w.removeDuplicateLetters("bcabc"));
    }

    public String removeDuplicateLetters(String s) {
        int[] dict = new int[26];//每个字母出现的次数
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            dict[chars[i] - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[26];//维护一个字母是否在sb中出现
        for (int i = 0; i < chars.length; i++) {
            if (!used[chars[i] - 'a']) {
                //sb中没有该字母
                int lastCh;
                while (sb.length() > 0 && (lastCh = sb.charAt(sb.length() - 1)) > chars[i] && dict[lastCh - 'a'] > 0) {
                    // 循环检测sb的最后一个字母是否大于该char
                    //后面是否还有该字母,有的话就删了用后面那个
                    sb.deleteCharAt(sb.length() - 1);
                    used[lastCh - 'a'] = false;
                }
                used[chars[i] - 'a'] = true;
                sb.append(chars[i]);//用一个
            }
            dict[chars[i] - 'a']--;// 不管用没用反正是过了;
        }
        return sb.toString();
    }


}
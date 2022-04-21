package Leetcode.smart;

/**
 * 0824 山羊拉丁文
 */

public class work0824 {
    public static void main(String[] args) {
        work0824 w = new work0824();
        System.out.println(w.toGoatLatin("I speak Goat Latin"));
    }

    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (i != 0) sb.append(' ');
            sb.append(toGoat(words[i], i + 1));
        }
        return sb.toString();
    }

    private StringBuilder toGoat(String word, int index) {
        StringBuilder sb = new StringBuilder();
        char first = word.charAt(0);
        if (isVowel(first)) {
            sb.append(word);
        } else {
            sb.append(word, 1, word.length());
            sb.append(first);
        }
        sb.append("ma");
        while (index-- > 0) sb.append('a');
        return sb;
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
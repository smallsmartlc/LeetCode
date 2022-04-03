package Leetcode.smart;

/**
 * 0744 寻找比目标字母大的最小字母
 */

public class work0744 {
    public static void main(String[] args) {
        work0744 w = new work0744();
        System.out.println(w.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(w.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println(w.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
        System.out.println(w.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g'));
        System.out.println(w.nextGreatestLetter(new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'}, 'e'));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0, r = n - 1;
        target++;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (letters[mid] == target) return letters[mid];
            else if (letters[mid] < target) l = mid + 1;
            else r = mid;
        }
        return letters[r] >= target ? letters[r] : letters[0];
    }
}
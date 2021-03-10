package Leetcode.smart;

public class ForOffer58 {
    public String reverseLeftWords1(String s, int n) {
        // 三次翻转,空间复杂度为1的骚操作
        // java字符串不方便调用,我们转为char数组
        char[] chars = s.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, s.length() - 1);
        reverse(chars, 0, s.length() - 1);
        return new String(chars);
    }

    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public String reverseLeftWords0(String s, int n) {
        return s.substring(n, s.length() - n - 1) + s.substring(0, n - 1);
    }

    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            res.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            res.append(s.charAt(i));
        }
        // 求余运算简化代码
//		for (int i = n; i < s.length() + n; i++) {
//			res.append(s.charAt(i%s.length()));
//		}
        return res.toString();
    }

    public static void main(String[] args) {
        ForOffer58 w = new ForOffer58();
        int[] nums = {2, 7, 11, 15};
        System.out.println(w.reverseLeftWords1("abcdefg", 2));
    }
}

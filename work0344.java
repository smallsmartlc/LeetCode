package Leetcode.smart;

//344. 反转字符串

public class work0344 {
    public static void main(String[] args) {
        work0344 w = new work0344();

        char[] s = "hello".toCharArray();
        w.reverseString(s);
        LecoUtil.LecoPrint(s);

    }

    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char temp = s[i];
            s[i] = s[len-1-i];
            s[len-1-i] = temp;
        }
    }

}
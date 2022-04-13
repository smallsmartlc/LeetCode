package Leetcode.smart;


/**
 * 0806 写字符串需要的行数
 */

public class work0806 {
    public static void main(String[] args) {
        work0806 w = new work0806();
        System.out.println(w.numberOfLines(new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}
        , "abcdefghijklmnopqrstuvwxyz"));
    }

    public int[] numberOfLines(int[] widths, String s) {
        int a = 1;
        int b = 0;
        for (char c : s.toCharArray()) {
            int width = widths[c - 'a'];
            if (b + width > 100){
                b = width;
                a++;
            }else b+= width;
        }
        return new int[]{a,b};
    }
}
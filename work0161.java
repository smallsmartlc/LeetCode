package Leetcode.smart;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode0161 相隔为 1 的编辑距离  (会员)
 * LintCode0640 一次编辑距离
 */

public class work0161 {
    public static void main(String[] args) {
        work0161 w = new work0161();
        System.out.println(w.isOneEditDistance("a","ab"));
    }

    public boolean isOneEditDistance(String s, String t) {
        // write your code here
        if(s.length() > t.length()){
            String temp = s;
            s = t;
            t = temp;
        }
        boolean edit = false;
        int len = s.length();
        if(s.length() == t.length()){
            for (int i = 0; i < len; i++) {
                if(s.charAt(i) != t.charAt(i)){
                    if(edit){
                        return false;
                    }else {
                        edit = true;
                    }
                }
            }
        }else{
            if (t.length()-s.length()>1) return false;
            for (int i = 0,j = 0; i < s.length(); i++) {
                if(s.charAt(j) != t.charAt(i)){
                    if(edit){
                        return false;
                    }else{
                        edit = true;
                    }
                }else {
                    j++;
                }
            }
            return true;
        }
         return edit;
    }
}

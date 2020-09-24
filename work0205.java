package Leetcode.smart;


import java.util.HashMap;
import java.util.Map;

public class work0205 {
    public static void main(String[] args) {
        work0205 w = new work0205();
        System.out.println(w.isIsomorphic("abb", "cdd"));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();

        int len = s.length();

        for (int i = 0; i < len; i++) {
            char schar = s.charAt(i);
            Integer sint = smap.get(schar);
            char tchar = t.charAt(i);
            Integer tint = tmap.get(tchar);
            if (sint != tint) return false;

            if (sint == null) {
                smap.put(schar, smap.size());
                tmap.put(tchar, tmap.size());
            }
        }
        return true;
    }
}
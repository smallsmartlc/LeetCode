package Leetcode.smart;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * leetcode 0288 单词的唯一缩写
 * lintcode 648 · 单词缩写集
 */
public class work0288 {

    public static void main(String[] args) {
        work0288 w = new work0288(new String[]{"deer", "door", "cake", "card"});

        System.out.println(w.isUnique("dear"));
        System.out.println(w.isUnique("cart"));
        System.out.println(w.isUnique("cane"));
        System.out.println(w.isUnique("make"));
    }

    private Map<String, HashSet<String>> map;

    public work0288(String[] dictionary) {
        // do intialization if necessary
        map = new HashMap<>(dictionary.length);
        for (String s : dictionary) {
            String sShort = getShort(s);
            map.putIfAbsent(sShort, new HashSet<>());
            map.get(sShort).add(s);
        }
    }

    private String getShort(String s) {
        if (s.length() < 3) {
            return s;
        } else {
            StringBuilder sb = new StringBuilder().append(s.charAt(0)).append(s.length() - 2).append(s.charAt(s.length() - 1));
            return sb.toString();
        }
    }

    /*
     * @param word: a string
     * @return: true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        // write your code here
        HashSet<String> set = map.get(getShort(word));
        return set == null || (set.contains(word) && set.size() == 1);
    }

}


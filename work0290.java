package Leetcode.smart;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 0290. 单词规律
 */
public class work0290 {

    public static void main(String[] args) {

        work0290 w = new work0290();
        int[] nums = new int[]{0,1,0,3,12};
        System.out.println(w.wordPattern("abba","dog dog dog dog"));
    }

    public boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] split = s.split(" ");
        if(chars.length != split.length) return false;
        Map<Character,String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if(map.containsKey(chars[i])){
                if(!map.get(chars[i]).equals(split[i])){
                    return false;
                }
            }else{
                if(set.contains(split[i])){
                    return false;
                }
                map.put(chars[i],split[i]);
                set.add(split[i]);
            }
        }
        return true;
    }

}


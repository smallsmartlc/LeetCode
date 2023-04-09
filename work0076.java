package Leetcode.smart;


import java.util.HashMap;
import java.util.Map;

//76. 最小覆盖子串
public class work0076 {
    public String minWindow1(String s, String t) {
        int[] set = new int[58];
        int[] map = new int[58];
        int size = 0;
        for (char c : t.toCharArray()) {
            if (set[c - 'A']++ == 0) size++;
        }
        char[] sList = s.toCharArray();
        int min = s.length() + 1;
        int left = -1, right = -1;
        for (int l = 0, r = 0; r < sList.length; r++) {
            int c = sList[r] - 'A';
            if (set[c] < 1) continue;
            map[c]++;
            while (check2(map, set,size)) {
                while (set[sList[l] - 'A'] == 0) l++;
                map[sList[l] - 'A']--;
                l++;
                if (r - l + 2 < min) {
                    left = l;
                    right = r;
                    min = r - l + 2;
                }
            }
        }
        return left == -1 ? "" : s.substring(left - 1, right + 1);
    }

    private boolean check2(int[] map, int[] set,int size) {
        int p = 0;
        for (int i = 0; i < 58; i++) {
            if (set[i] > 0 && map[i] >= set[i]) p++;
        }
        return p == size;
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> set = new HashMap<>();
        for (char c : t.toCharArray()) {
            set.put(c, set.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] sList = s.toCharArray();
        int min = s.length() + 1;
        int left = -1, right = -1;
        for (int l = 0, r = 0; r < sList.length; r++) {
            char c = sList[r];
            if (!set.containsKey(c)) {
                continue;
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
                while (check(map, set)) {
                    while (l < r && !set.containsKey(sList[l])) {
                        l++;
                    }
                    map.put(sList[l], map.getOrDefault(sList[l], 0) - 1);
                    l++;
                    if (r - l + 2 < min) {
                        left = l;
                        right = r;
                        min = r - l + 2;
                    }
                }
        }
        return left == -1 ? "" : s.substring(left - 1, right + 1);
    }

    private boolean check(Map<Character, Integer> map, Map<Character, Integer> set) {
        for (Map.Entry<Character, Integer> entry : set.entrySet()) {
            Character c = entry.getKey();
            if (map.getOrDefault(c, 0) < entry.getValue()) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        work0076 w = new work0076();
//		int[] nums = new int[] {1,2,0};
        System.out.println(w.minWindow1("ADOBECODEBANC", "ABC"));
    }
}

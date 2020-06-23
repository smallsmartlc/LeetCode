package Leetcode.smart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

 */
public class work0049 {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> res = new HashMap<>();
		for (String str : strs) {
			char[] c = str.toCharArray();
			Arrays.sort(c);
			String key = new String(c);
			if(!res.containsKey(key)) {
				res.put(key, new ArrayList<>());
			}
			res.get(key).add(str);
		}
		return new ArrayList<>(res.values());
    }
	public static void main(String[] args) {
		work0049 w = new work0049();
		Map<Character[], Integer> res = new HashMap<>();
		String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(w.groupAnagrams(strs));
	}
}

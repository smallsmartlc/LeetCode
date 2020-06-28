package Leetcode.smart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class work0187{
	public static void main(String[] args) {
		work0187 w = new work0187();
		System.out.println(w.findRepeatedDnaSequences("AAAAAAAAAAA"));
	}
	public List<String> findRepeatedDnaSequences(String s) {
		int left = 0;
		int right = 10;
		List<String> list = new ArrayList<>();
		Map<String,Boolean> map = new HashMap<>();
		while (right<=s.length()) {
			String str = s.substring(left, right);
			if(map.containsKey(str)) {
				if(map.get(str)) {
					map.put(str, false);
					list.add(str);
				}
			}else {
				map.put(str, true);
			}
			left++;
			right++;
		}
		
		return list;
    }
}
package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

public class work0131 {
	
	List<List<String>> res = new ArrayList<>();
	public List<List<String>> partition(String s) {
		List<String> list = new ArrayList<>();
		dif(s, 0, list);
		return res;
    }
	public void dif(String s,int index,List<String> list) {
		if(index>=s.length()) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = index; i < s.length(); i++) {
			if(!checkPalindrome(s, index, i)) continue;
			list.add(s.substring(index, i+1));
			dif(s, i+1, list);
			list.remove(list.size()-1);
		}
	}
	private boolean checkPalindrome(String s, int left, int right) {
        // 严格小于即可
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
	public static void main(String[] args) {
		work0131 w= new work0131();
		System.out.println(w.partition("aab"));
	}
}

package Leetcode.smart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class work0017 {
	List<String> list = new ArrayList<>();
	public List<String> letterCombinations2(String s){
		if(s.equals("")) return list;
		findCombination(s, 0, "");
		return list;
	}
	private final char[][] abc = {{'a','b','c'},{'d','e','f'},{'g','h','i'}
    ,{'j','k','l'},{'m','n','o'},{'p','q','r','s'}
    ,{'t','u','v'},{'w','x','y','z'}};
	private void findCombination(String s,int index,String temp) {
		if(index==s.length()) {
			list.add(temp);
			return;
		}
		char c = s.charAt(index);
		for (char ch : abc[c-'2']) {
			findCombination(s, index+1, temp+ch);
		}
	}
	public List<String> letterCombinations(String s) {
		LinkedList<String> list = new LinkedList<>();
		if(s.equals("")) return list;
		 char[][] abc = {{'a','b','c'},{'d','e','f'},{'g','h','i'}
         ,{'j','k','l'},{'m','n','o'},{'p','q','r','s'}
         ,{'t','u','v'},{'w','x','y','z'}};
		 list.add("");
		for(int i =0;i<s.length();i++) {
			int num = Character.getNumericValue(s.charAt(i))-2;
			while(list.peek().length()<i+1) {
				String res  = list.remove();
				for(char c:abc[num]) {
					list.add(res+c);
				}
			}
		}
		
		return list;

    }
	public static void main(String[] args) {
		work0017 w = new work0017();
		System.out.println(w.letterCombinations2("2346683"));
	}
}

package Leetcode.smart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class work0093 {
	List<String>res = new ArrayList<>();
	public List<String> restoreIpAddresses(String s) {
        if(s.length()<4||s.length()>12) return Collections.EMPTY_LIST;
        addRes(4, 0, s.toCharArray(), "");
		return res;
    }
	public void addRes(int len,int index,char[] ch,String s) {
		if(ch.length-index<len||ch.length-index>3*len) return;
		if(ch.length-index==0) {
			res.add(new String(s.substring(0, s.length()-1)));
			return;
		} 
		String temp = "";
		for (int i = index; i<ch.length&&i < index+3; i++) {
			temp =temp + ch[i];
			if(Integer.parseInt(temp)>255) break;
			addRes(len-1, i+1, ch, s+temp+".");
			if(i==index&&ch[i]=='0') break;
		}
	}
	public static void main(String[] args) {
		work0093 w= new work0093();
		
		System.out.println(w.restoreIpAddresses("010010"));
	}
}

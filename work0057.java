package Leetcode.smart;

public class work0057 {
	public int lengthOfLastWord(String s) {
		//0ms;
		s = s.trim();
		int i = s.length()-1;
		while(s.charAt(i)!=' ') {
			i--;
		}
		return s.length()-1-i;
	}
	public int lengthOfLastWord2(String s) {
		//1ms
		if(s.trim().equals("")) return 0;
		String[] res = s.split(" ");
		return res[res.length-1].length();
	}
	public static void main(String[] args) {
		work0057 w = new work0057();
		System.out.println(w.lengthOfLastWord("hello world "));
	}
}

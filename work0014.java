package Leetcode.smart;

public class work0014 {
	public String longestCommonPrefix(String[] strs) {
		if	(strs.length==0) return "";
		String res = "";
		for (int i = 0; i<strs[0].length(); i++) {
			char temp = strs[0].charAt(i);
			for (int j = 0; j < strs.length; j++) {
				if(i>=strs[j].length()) return res.replaceAll(" ", "");
				if (temp!= strs[j].charAt(i)) {
					return res.replaceAll(" ", "");
				}
			}
			res += "" + temp;
		}
		return res.replaceAll(" ", "");
	}

	public static void main(String[] args) {
		work0014 w = new work0014();
		String[] strs = { "aca", "cba",};
		String[] strs2 = {"flower","flow","flight"};
		System.out.println(w.longestCommonPrefix(strs2));
	}
}

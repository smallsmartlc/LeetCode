package Leetcode.smart;

public class work0013 {
	public int romanToInt(String s) {
		char[] roman = new char[] {'I','V','X','I','X','L','C','X','C','D','M','C','M'};
		int[] num = new int[] {1,5,10,-1,10,50,100,-10,100,500,1000,-100,1000};
		int res = 0;
		int index = 0;
		for(int i = s.length()-1;i>=0;i--) {
			while(s.charAt(i)!=roman[index]) {
				index++;
			}
			res+=num[index];
		}
		return res;
	}
	public static void main(String[] args) {
		work0013 w = new work0013();
		System.out.println(w.romanToInt("MDCCCLXXXIV"));
	}
}

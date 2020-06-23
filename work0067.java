package Leetcode.smart;

public class work0067 {
	public String addBinary(String a, String b) {
		//³¬Ê±
        String res = "";
        if(a.length()<b.length()) {
        	String temp = a;
        	a = b;
        	b = temp;
        }
        while(a.length()>b.length()) {
        	b = '0'+b;
        }
        int i = a.length()-1;
        int carry = 0;
        while(i>=0) {
        	if(a.charAt(i)=='1'&&b.charAt(i)=='1') {
        		res = carry + res;
        		carry = 1;
        	}else if(a.charAt(i)=='0'&&b.charAt(i)=='0') {
        		res = carry + res;
        		carry = 0;
        	}else {
        		res = 1-carry+res;
        	}
        	i--;
        }
        if (carry == 1) res = carry + res ;
        return res;
    }
	public static void main(String[] args) {
		work0067 w= new work0067();
		String nums = "1111";
		System.out.println(w.addBinary("11","1"));
	}
}

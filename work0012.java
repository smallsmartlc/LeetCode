package Leetcode.smart;

public class work0012 {
	public String intToRoman(int num) {
		String res="";
		while(num>=1000) {
			num-=1000;
			res+="M";
		}
		if(num/100==9) {
			res+="CM";
			num-=900;
		}else if(num/100==4) {
			res+="CD";
			num-=400;
		}
		while(num>=500) {
			num-=500;
			res+="D";
		}
		while(num>=100) {
			num-=100;
			res+="C";
		}
		if(num/10==9) {
			res+="XC";
			num-=90;
		}else if(num/10==4) {
			res+="XL";
			num-=40;
		}
		while(num>=50) {
			num-=50;
			res+="L";
		}
		while(num>=10) {
			num-=10;
			res+="X";
		}
		if(num/1==9) {
			res+="IX";
			num-=9;
		}else if(num/1==4) {
			res+="IV";
			num-=4;
		}
		while(num>=5) {
			num-=5;
			res+="V";
		}
		while(num>=1) {
			num-=1;
			res+="I";
		}
		
		return res;
    }
	public static void main(String[] args) {
		work0012 w = new work0012();
		System.out.println(w.intToRoman(1884));

	}
}

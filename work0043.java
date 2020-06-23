package Leetcode.smart;


public class work0043 {
	int[] nums = new int[220];
	public void addNumber(int index , int value) {
		nums[index] += value;
		int i = 0;
		while(nums[index+i]>=10) {
			nums[index+i+1] += nums[index+i]/10;
			nums[index+i] %= 10;
			i++;
		}
	}
	public String multiply(String num1, String num2) {
		String res = "";
		if(num1.equals("0")||num2.equals("0")) return "0";
		for(int i = 0 ;i<num1.length();i++) {
			for(int j = 0 ;j<num2.length();j++) {
				int a = num1.charAt(num1.length()-1-i)-'0';
				int b = num2.charAt(num2.length()-1-j)-'0';
				addNumber(i+j, a*b);
			}
		}
		System.out.println(num1.length()+num2.length()-1);
		for(int i = num1.length()+num2.length()-1;i>=0;i--) {
			res+= nums[i];
		}
		return res.replaceFirst("^(0)", "");
    }
	public static void main(String[] args) {
		work0043 w = new work0043();
		String num2 = "2";
		String num1 = "3";
		System.out.println(w.multiply(num1, num2));
	}
}

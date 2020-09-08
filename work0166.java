package Leetcode.smart;

import java.util.HashMap;
import java.util.Map;

public class work0166 {
	public static void main(String[] args) {
		work0166 w = new work0166();
		System.out.println(w.fractionToDecimal(2, 3));
	}

	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) {
	        return "0";
	    }
		StringBuilder fraction = new StringBuilder();
		if (numerator < 0 ^ denominator < 0) {
	        fraction.append("-");
	    }
		long dividend = Math.abs(numerator);
		long divisor = Math.abs(denominator);
		fraction.append(dividend/divisor);
		long remainder = dividend%divisor;
		if(remainder == 0) return fraction.toString();
		fraction.append(".");
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		while(remainder!=0) {
			if(map.containsKey(remainder)) {
				fraction.insert(map.get(remainder), "(");
				fraction.append(")");
				break;
			}
			map.put(remainder, fraction.length());
			remainder*=10;
			fraction.append(remainder/divisor);
			remainder %= divisor;
		}
		return fraction.toString();
	}
}


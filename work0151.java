package Leetcode.smart;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class work0151 {
	public static void main(String[] args) {
		 work0151 w = new work0151();
		 String s1 ="the sky is blue";
		 String s2 ="  hello world!  ";
		 String s3 = "a good   example";
		 System.out.println(w.reverseWords(s1));
	}
	public String reverseWords(String s) {
		s.trim();
		int start = 0;
		List<String> wordlist = Arrays.asList(s.split("\\s+"));
		Collections.reverse(wordlist);
		return String.join(" ", wordlist);
    }
}
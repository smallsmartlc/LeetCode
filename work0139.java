package Leetcode.smart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class work0139 {
	public boolean wordBreak(String s, List<String> wordDict) {
		return word_Break(s, new HashSet<>(wordDict), 0,new Boolean[s.length()]);
	}
	public boolean word_Break(String s, Set<String> wordDict, int start , Boolean[] memo) {
		if(start == s.length()) return true;
		if (memo[start] != null) {
            return memo[start];
        }
		for (int end = start + 1; end <= s.length(); end++) {
			if(wordDict.contains(s.substring(start, end))&&word_Break(s, wordDict, end, memo)) return memo[start] = true;
		}
		return memo[start] = false;
	}
	public boolean wordBreak0(String s, List<String> wordDict) {
		//µÝ¹é,³¬Ê±
		return word_Break0(s, new HashSet<>(wordDict), 0);
    }
	public boolean word_Break0(String s, Set<String> wordDict, int start) {
		if(start == s.length()) return true;
		for (int end = start + 1; end <= s.length(); end++) {
			if(wordDict.contains(s.substring(start, end))&&word_Break0(s, wordDict, end)) return true;
		}
		return false;
	}
	public static void main(String[] args) {
		work0139 w = new work0139();
		String[] s = new String[] {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
 		System.out.println(w.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
 				,new ArrayList<>(Arrays.asList(s))));
	}
}

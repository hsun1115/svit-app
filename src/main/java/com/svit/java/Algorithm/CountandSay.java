package com.svit.java.Algorithm;

public class CountandSay {
	public String countAndSay(int n) {
		String s = "1";
		for (int i = 1; i < n; i++) {
			s = helper(s);
		}
		return s;
	}

	public String helper(String s) {
		StringBuilder sb = new StringBuilder();
		char say = s.charAt(0);
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == say) {
				count++;
			} else {
				sb.append(count);
				sb.append(say);
				say = s.charAt(i);
				count = 1;
			}
		}
		sb.append(count);
		sb.append(say);
		return sb.toString();
	}
}

package com.svit.java.Algorithm;

import java.util.HashMap;
import java.util.Map;

public class CountandPrint {
	public static void main(String[] args) {
		String s = "aAsss223545";
		countandPrint(s);
	}

	public static void countandPrint(String s) {
		Map<Character, Integer> res = new HashMap<Character, Integer>();
		char[] list = s.toLowerCase().toCharArray();
		for (char c : list) {
			// if(!res.containsKey(c)) {
			res.put(c, res.getOrDefault(c, 0) + 1);
			// }
		}
		for (char a : res.keySet()) {
			System.out.println(a + "===" + res.get(a));
		}
	}
}

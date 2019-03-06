package com.svit.java.Algorithm;

public class ReverseString {
	public String reverseString(String s) {
		char[] word = s.toCharArray();
		int i=0,j=word.length-1;
		while(i<j) {
			char temp=word[i];
			word[i]=word[j];
			word[j]=temp;
			i++;
			j--;
		}
		return new String(word);
	}
	public void reverseString(char[] s) {
		int i=0,j=s.length-1;
		while(i<j) {
			char temp=s[i];
			s[i]=s[j];
			s[j]=temp;
			i++;
			j--;
		}
	}
}

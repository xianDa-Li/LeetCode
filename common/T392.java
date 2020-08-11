package com.company.leetcode.common;

import java.util.ArrayDeque;
import java.util.Deque;

public class T392 {

	public static void main(String[] args) {
		T392 t392 = new T392();
		String s = "axc";
		String t = "ahbgdc";
		boolean ans = t392.isSubsequence(s,t);
		System.out.println(ans);
	}

	public boolean isSubsequence(String s, String t) {
		Deque<Character> stack = new ArrayDeque<>();
		int slen = s.length();
		int tlen = t.length();
		if(slen == 0) return true;
		for(int i=slen-1;i>=0;i--){
			stack.push(s.charAt(i));
		}

		for(int i=0;i<tlen;i++){
			if(stack.peek()==t.charAt(i))
				stack.pop();
			if(stack.isEmpty())
				return true;
		}
		return false;
	}


}

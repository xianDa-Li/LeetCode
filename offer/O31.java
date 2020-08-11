package com.company.leetcode.offer;

import java.util.Stack;

public class O31 {

	public static void main(String[] args) {
		int[] pushed = {1,2,3,4,5};
		int[] popped = {4,5,3,2,1};
//		int[] pushed = {1,0};
//		int[] popped = {1,0};
		boolean ans = validateStackSequences(pushed,popped);
		System.out.println(ans);
	}
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		if(pushed.length==0 && popped.length==0) return true;
		Stack<Integer> s = new Stack<>();
		int j = 0;
		for(int i=0;i<pushed.length;i++){
			s.push(pushed[i]);
			while(!s.empty() && s.peek() == popped[j] ){
					s.pop();
					j++;
			}
		}
		return s.empty();
	}
}

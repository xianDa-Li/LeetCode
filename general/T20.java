package com.company.leetcode.general;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: XianDaLi
 * Date: 2020/8/14 4:35
 * Remark:给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class T20 {
	/*
	时间O(n)
	空间O(n)
	 */
	public static void main(String[] args) {
		String s = "([)]";
		boolean b = isValid(s);
		System.out.println(b);
	}
	public static boolean isValid(String s) {
		int len = s.length();
		if(len==0) return true;
		Deque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < len; i++) {
			char temp = s.charAt(i);
			if(temp == '(') stack.push(')');
			else if(temp == '[') stack.push(']');
			else if(temp == '{') stack.push('}');
			else if(stack.isEmpty() || temp != stack.pop())
				return false;
		}
		return stack.isEmpty();
	}
}

package com.company.leetcode.offer;

/**
 * Author: XianDaLi
 * Date: 2020/9/1 12:33
 * Remark:
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
public class T58_1 {

	/*
		分隔字符串，之后倒叙遍历拼接字符串，遇到空格则continue;
		时间O(n)
		空间O(n)
	 */
	public String reverseWords(String s) {
		if(s.length()==0) return s;
		String[] ss = s.trim().split(" ");
		int len = ss.length-1;
		StringBuilder sb = new StringBuilder();
		for(int i =len;i>=0;i--){
			if(ss[i].equals("")) continue;
			sb.append(ss[i]+" ");
		}
		return sb.toString().trim();
	}
}

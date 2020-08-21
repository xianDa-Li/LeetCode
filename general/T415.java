package com.company.leetcode.general;

/**
 * Author: XianDaLi
 * Date: 2020/8/19 15:27
 * Remark:给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 */
public class T415 {

	public String addStrings(String num1, String num2) {
		int a=num1.length()-1;
		int b=num2.length()-1;
		int c = 0;
		StringBuilder sb = new StringBuilder();
		while(a>=0 || b>=0 || c != 0){
			int x = a >= 0 ? num1.charAt(a) - '0' : 0;
			int y = b >= 0 ? num2.charAt(b) - '0' : 0;
			int temp = x+y+c;
			c = temp/10;
			sb.append(temp%10);
			a--;b--;
		}
		return sb.reverse().toString();
	}
}

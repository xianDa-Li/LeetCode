package com.company.leetcode.general;

/**
 * Author: XianDaLi
 * Date: 2020/8/13 19:50
 * Remark:给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class T43 {

	/*
	方法一：模拟竖式乘法
	思路:
		模拟竖式乘法。用num2的每一位数去乘num1的全部，然后依次做字符串相加即可。
		这里的字符串相加是T415原题
		时间O(mn)
		空间(m+n)
	 */

	public static void main(String[] args) {
		T43 t43 = new T43();
		String num1 = "2";
		String num2 = "3";
		String ans = t43.multiply(num1,num2);
		System.out.println(ans);
	}
	public String multiply(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0")) return "0";

		String ans  = "0";

		for (int i = num2.length()-1; i >= 0;i--) {
			int lastNum = 0;
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < num2.length()-1-i; j++) {
				sb.append(0);
			}
			int n2 = num2.charAt(i) - '0';

			for (int j = num1.length()-1; j >=0 || lastNum !=0; j--) {
				int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
				int nowNum = n1 * n2 + lastNum;
				sb.append(nowNum%10);
				lastNum = nowNum/10;
			}
//			if(lastNum != 0) sb.append(lastNum);
			ans = addStrings(ans,sb.reverse().toString());
		}
		return ans;
	}

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

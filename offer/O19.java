package com.company.leetcode.offer;

/**
 * Author: XianDaLi
 * Date: 2020/8/16 6:13
 * Remark:请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 */
public class O19 {
	/*
		方法一：从左向右遍历
		思路：dp[i][j]为s字符串的第i个字符与p字符串的第j个字符是否匹配
		主要三种情况：
			j = '*' 需要判断j-1是否匹配 将j-1带入match看是否匹配
			j = '.' 匹配任意字母
			j = 字母 只匹配当前字母
		时间O(m*n)
		空间O(m*n)
	 */
	public boolean isMatch(String s, String p) {
		int sl = s.length();
		int pl = p.length();
		boolean[][] dp = new boolean[sl + 1][pl + 1];
		dp[0][0] = true;
		for (int i = 0; i <= sl; i++) {
			for (int j = 1; j <= pl; j++) {
				if(p.charAt(j-1) == '*'){
					dp[i][j] = dp[i][j - 2];
					if(match(s,p,i,j-1)) dp[i][j] = dp[i][j] || dp[i-1][j];
				}else {
					if(match(s,p,i,j)) dp[i][j] = dp[i-1][j-1];
				}
			}
		}
		return dp[sl][pl];
	}

	public boolean match(String s, String p, int i, int j){
		if(i==0) return false;
		if(p.charAt(j-1)=='.') return true;
		return s.charAt(i-1) == p.charAt(j-1);
	}

	/*
		方法二：与方法一大同小异，整合在一个方法，便于理解
	 */
	public boolean isMatch2(String s, String p) {
		int sl = s.length();
		int pl = p.length();
		boolean[][] dp = new boolean[sl + 1][pl + 1];
		dp[0][0] = true;

		for(int j=1;j<=pl;j++){
            /*
                当s为空时，a*b*c*可以匹配
                当判断到下标j-1是*，j-2是b，b对应f，要看之前的能否匹配
                比如a*b*下标依次为ftft，b之前的位t，所以j-1也是true
                即dp[0][j]对应的下标j-1位true
            */
			if(j==1)
				dp[0][j]=false;
			if(p.charAt(j-1)=='*') //当dp[0][j]下标j-1是'*',则判断其之前的j-2是否匹配
				dp[0][j]=dp[0][j-2];
		}

		for (int i = 1; i <= sl; i++) {
			for (int j = 1; j <= pl; j++) {
				if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1)=='.') dp[i][j] = dp[i-1][j-1];
				else if(p.charAt(j-1) == '*'){
					if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')
						dp[i][j] = dp[i][j-2] || dp[i-1][j-2] || dp[i-1][j];
					else dp[i][j] = dp[i][j-2];
				}
			}
		}
		return dp[sl][pl];
	}
}

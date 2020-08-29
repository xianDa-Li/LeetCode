package com.company.leetcode.general;

/**
 * Author: XianDaLi
 * Date: 2020/8/28 8:47
 * Remark:657. 机器人能否返回原点
 */
public class T657 {
	public static void main(String[] args) {
		String moves = "UD";
		boolean ans = judgeCircle(moves);
		System.out.println(ans);
	}
	public static boolean judgeCircle(String moves) {
		int x = 0;
		int y = 0;
		for(int i=0;i<moves.length();i++){
			if(moves.charAt(i) == 'L') x++;
			if(moves.charAt(i) == 'R') x--;
			if(moves.charAt(i) == 'U') y++;
			if(moves.charAt(i) == 'D') y--;
		}
		System.out.println(x);
		System.out.println(y);
		return x==0 && y==0;
	}
}

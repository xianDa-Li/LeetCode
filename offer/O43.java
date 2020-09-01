package com.company.leetcode.offer;

/**
 * Author: XianDaLi
 * Date: 2020/9/1 13:45
 * Remark:
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 */
public class O43 {
	public static void main(String[] args) {
		int n = 12;
		int ans = countDigitOne(n);
		System.out.println(ans);
	}
	public static int countDigitOne(int n) {
		int count = 0;
		for(long pos = 1;pos<=n;pos*=10){
			long big = n/pos;
			long small = n%pos;
			if(big %10 == 1){
				count += small+1;
			}
			count+=(big+8)/10 * pos;
		}
		return count;
	}
}

package com.company.leetcode.offer;

import java.util.Random;

/**
 * Author: XianDaLi
 * Date: 2020/9/2 21:22
 * Remark:
 */
public class O44 {

	/**
	 * 数学方法 找规律
	 * @param n
	 * @return
	 */
	public int findNthDigit(int n) {
		int p = 1;
		long s = 1;
		long count = 9;
		while (n > count){
			n-= count;
			p += 1;
			s *= 10;
			count = p * s * 9;
		}
		long num = s + (n-1)/p;
		return Long.toString(num).charAt((n-1)%p)-'0';
	}
}

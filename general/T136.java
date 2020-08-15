package com.company.leetcode.general;

/**
 * Author: XianDaLi
 * Date: 2020/8/14 16:42
 * Remark:给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 规定时间O(n)内，空间O(1)
 */
public class T136 {
	/*
	找出无重复的数，题目规定时间O(n)内，空间O(1)
	故用位运算，
		1.任何数和 00 做异或运算，结果仍然是原来的数，即 a \oplus 0=aa⊕0=a。
		2.任何数和其自身做异或运算，结果是 00，即 a \oplus a=0a⊕a=0。
		3.异或运算满足交换律和结合律，即 a \oplus b \oplus a=b \oplus a \oplus a=b \oplus (a \oplus a)=b \oplus0=ba⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。

	 */
	public int singleNumber(int[] nums) {
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			ans ^= nums[i];
		}
		return ans;
	}
}

package com.company.leetcode.offer;


/**
 * Author: XianDaLi
 * Date: 2020/8/16 5:06
 * Remark:输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 */
public class O42 {
	/*
		思路：数组dp[i]为前0-i元素中的连续子数组和的最大值
		时间O(n)
		空间O(1)
	 */
	public int maxSubArray(int[] nums) {
		int ans = nums[0];
		for (int i = 1; i < nums.length; i++) {
			nums[i] += Math.max(nums[i-1],0);
			ans = Math.max(ans,nums[i]);
		}
		return ans;
	}
}

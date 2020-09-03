package com.company.leetcode.general;

/**
 * Author: XianDaLi
 * Date: 2020/9/2 12:22
 * Remark:
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class T53 {
	public int maxSubArray(int[] nums) {
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			nums[i] += Math.max(nums[i-1],0);
			max = Math.max(max,nums[i]);
		}
		return max;
	}
}

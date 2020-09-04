package com.company.leetcode.offer;

/**
 * Author: XianDaLi
 * Date: 2020/8/19 15:30
 * Remark:一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class O53_2 {

	/*
		二分查找就完事了
		时间O(logn)
		空间O(1)
	 */
	public int missingNumber(int[] nums) {
		if(nums[0] != 0) return 0;
		int l = 0;
		int r = nums.length-1;
		while (l<=r){
			int m = (l+r)/2;
			if(nums[m] == m) l = m+1;
			else r = m-1;
		}
		return l;
	}

}

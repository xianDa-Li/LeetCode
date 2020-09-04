package com.company.leetcode.offer;

/**
 * Author: XianDaLi
 * Date: 2020/9/4 2:38
 * Remark:
 */
public class O53_1 {
	public int search(int[] nums, int target) {
		return res(nums,target) - res(nums,target-1);
	}

	int res(int[] nums, int target) {
		int l = 0;
		int r = nums.length-1;
		while (l<=r){
			int m = (l+r)/2;
			if(nums[m] <= target) l = m+1;
			else r = m-1;
		}
		return l;
	}
}

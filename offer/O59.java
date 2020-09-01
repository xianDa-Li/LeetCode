package com.company.leetcode.offer;

/**
 * Author: XianDaLi
 * Date: 2020/9/1 0:40
 * Remark:
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class O59 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] ans = new int[nums.length];
		int l = 0;
		int r = k;
		while (r<=nums.length){
			r = k+l;
			int max = nums[l];
			for (int i = l; i<r; i++) {
				max = Math.max(max,nums[l]);
			}
			ans[l] = max;
			l++;
			r = l+k;
		}
		return ans;
	}
}

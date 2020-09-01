package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/1 12:53
 * Remark:
 */
public class T486 {
	public boolean PredictTheWinner1(int[] nums) {
		int sum = 0;
		for (int n: nums) {
			sum+=n;
		}
		int first = f(nums,0,nums.length-1);
		return first>=(sum-first);
	}
	int f(int[] nums,int i,int j){
		if(i==j) return nums[i];
		if(i+1 == j) return Math.max(nums[i],nums[j]);

		return Math.max(
				nums[i]+Math.min(f(nums,i+1,j-1),f(nums,i+2,j)),
				nums[j]+Math.min(f(nums,i+1,j-1),f(nums,i,j-2)));
	}

	public boolean PredictTheWinner2(int[] nums) {
		return total(nums,0,nums.length-1,1) >= 0;
	}

	int total(int[] nums, int l, int r, int t) {
		if(l == r) return nums[l]*t;
		int sl = nums[l]*t + total(nums,l+1,r,-t);
		int sr = nums[r]*t + total(nums,l,r-1,-t);
		return Math.max(sl*t,sr*t)*t;
	}

}

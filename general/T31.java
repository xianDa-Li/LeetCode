package com.company.leetcode.general;

import java.util.Arrays;

/**
 * Author: XianDaLi
 * Date: 2020/9/2 12:53
 * Remark:
 */
public class T31 {
	public void nextPermutation(int[] nums) {
		int len = nums.length;
		for (int i = len-1; i > 0; i--) {
			if(nums[i]>nums[i-1]){
				Arrays.sort(nums,i,len);
				for (int j = i; j < len; j++) {
					if(nums[j]>nums[i-1]){
						int temp = nums[j];
						nums[j]=nums[i-1];
						nums[i-1]=temp;
						return;
					}
				}
			}
		}
		Arrays.sort(nums);
		return;
	}
}
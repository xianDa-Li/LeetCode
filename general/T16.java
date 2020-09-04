package com.company.leetcode.general;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Author: XianDaLi
 * Date: 2020/9/4 0:44
 * Remark:
 */
public class T16 {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int min = nums[0]+nums[1]+nums[2];
		for (int i = 0; i < nums.length; i++) {
			int l = i+1;
			int r = nums.length-1;
			while (r>l){
				int sum = nums[i]+nums[l]+nums[r];
				if(Math.abs(sum-target) < Math.abs(min-target))
					min = sum;
				if(sum>target) r--;
				else if(sum<target) l++;
				else return target;
			}
		}
		return min;
	}
}

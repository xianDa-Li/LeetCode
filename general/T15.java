package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/4 0:53
 * Remark:
 */
public class T15 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]>0) break;
			if(i!=0 && nums[i] == nums[i-1]) continue;
			int l = i+1;
			int r = nums.length-1;
			while (l<r){
				int sum = nums[i]+nums[l]+nums[r];
				if(sum == 0){
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[l]);
					temp.add(nums[r]);
					list.add(temp);
					l++;r--;
					while (l<r && nums[r]==nums[r+1]) r--;
					while (l<r && nums[l]==nums[l-1]) l++;
				}else if(sum > 0) r--;
				else l++;
			}
		}
		return list;
	}
}

package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/10 3:41
 * Remark:
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 */
public class T1262 {

	/*
		数学方法
	 */
	public int maxSumDivThree2(int[] nums) {
		List<Integer> one = new ArrayList<>();
		List<Integer> two = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]%3==1) one.add(nums[i]);
			if(nums[i]%3==2) two.add(nums[i]);
			sum += nums[i];
		}
		if(sum%3==0) return sum;
		Collections.sort(one);
		Collections.sort(two);
		int ans = 0;
		if(sum%3==1){
			if(one.size()>=1) ans = Math.max(ans,sum-one.get(0));
			if(two.size()>=2)ans = Math.max(ans,sum-two.get(0)-two.get(1));
		}
		if(sum%3==2){
			if(one.size()>=2) ans = Math.max(ans,sum-one.get(0)-one.get(1));
			if(two.size()>=1) ans = Math.max(ans,sum-two.get(0));
		}
		return ans;
	}
}

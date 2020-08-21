package com.company.leetcode.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: XianDaLi
 * Date: 2020/8/17 22:51
 * Remark:数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 */
public class O39 {

	/*
	摩尔投票法: 写法一
		遍历数组 nums 中的每个数字 num;
		当 票数 votes 等于 0 ，则假设 当前数字 num 为 众数 x;
		当 num = x 时，票数 votes 自增 1; 否则，票数 votes 自减 1 。
	时间O(n)
	空间O(1)
	 */
	public int majorityElement(int[] nums){
		int x = 0;
		int votes = 0;
		for (int i = 0; i <nums.length ; i++) {
			if(x != nums[i] && votes == 0){
					x = nums[i];
					votes++;
			} else if(x != nums[i] && votes > 0) votes--;
			else votes++;
		}
		return x;
	}

	/*
		摩尔投票法:写法二
	 */
	public int majorityElement12(int[] nums){
		int x = 0;
		int votes = 0;
		int temp = 0;
		for (int num:nums) {
			if(votes == 0) x = num;
			temp = num == x ? 1 : -1;
			votes += temp;
		}
		return x;
	}

	/*方法二：map
	时间O(n)
	空间O(n)
	 */
	public int majorityElement2(int[] nums){
		Map<Integer,Integer> hm = new HashMap<>();
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if(hm.containsKey(nums[i])){
				if(hm.get(nums[i]) > len/2) return nums[i];
				hm.put(nums[i],hm.get(nums[i])+1);
			} else hm.put(nums[i],1);
		}
		return nums[0];
	}

	/*
	方法三：快速排序
	需要的数字出现次数多于一半 那么排序后必定在中间
	时间O(logn)
	空间O(1)
	 */
	public int majorityElement3(int[] nums){
		Arrays.sort(nums);
		return nums[nums.length/2];
	}

}

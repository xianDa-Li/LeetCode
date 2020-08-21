package com.company.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: XianDaLi
 * Date: 2020/8/18 0:04
 * Remark:输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 */
public class O57 {

	/*
	方法一：双指针
		思路：
			1.因为是递增数组，如果nums[left] + nums[right] > target
				则right往前移动。这样能让nums[right]的值减小，则nums[left] + nums[right]的和也减小
			2.如果nums[left] + nums[right] < target
				则left往后移动。这样能让nums[left]的值增大，则nums[left] + nums[right]的和也增大
			3.如果nums[left] + nums[right] == target
				则直接跳出循环，将nums[left],nums[right] 放入返回的数组即可。
		时间O(n)
		空间O(1)
	 */
	public int[] twoSum(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while (left < right){
			if(nums[left] + nums[right] > target) right--;
			else if(nums[left] + nums[right] < target) left++;
			else break;
		}
		return new int[]{nums[left],nums[right]};
	}

	/*
	方法二：map
		思路：将 nums[i]为key,target-nums[i]为value依次放入map中，当key存在target-num时，取出<k,V>放入ans数组即可
		时间O(n)
		空间O(n)
 */
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer,Integer> hm = new HashMap<>();
		int[] ans = new int[2];
		for(int num : nums){
			if(hm.containsKey(target-num)){
				ans[0] = num;
				ans[1] = target-num;
				break;
			}
			hm.put(num,target-num);
		}
		return ans;
	}
}

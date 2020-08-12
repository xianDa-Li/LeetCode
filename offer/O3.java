package com.company.leetcode.offer;

/**
 * Author: XianDaLi
 * Date: 2020/8/12 8:11
 * Remark:
 */
public class O3 {

	/*
	方法一：set集合，边存入边比较
		时间O(n)
		空间O(n)
		public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }
	 */

	/*
	方法二 : 数值交换
		时间O(n)
		空间O(1)
	 */
	public int findRepeatNumber(int[] nums) {
		int n = nums.length;
		// 1~n-1
		for(int num : nums){
			if(num<0||num>=n)
				return -1;
		}
		//利用下标交换 保证下标 == 元素值
		for(int i=0;i<n;i++){
			while(nums[i] != i && nums[nums[i]]!=nums[i])
				swap(nums,i,nums[i]);//交换numns[i] nums[nums[i]]
			if(nums[i] != i && nums[nums[i]] == nums[i])
				return nums[i];
		}
		return -1;
	}

	public void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}

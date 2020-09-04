package com.company.leetcode.general;

import java.util.Arrays;

/**
 * Author: XianDaLi
 * Date: 2020/9/4 3:08
 * Remark:
 */
public class T34 {
	public static void main(String[] args) {
		T34 t = new T34();
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		int[] ans = t.searchRange(nums,target);
		System.out.println(Arrays.toString(ans));
	}
	public int[] searchRange(int[] nums, int target) {
		int l = findF(nums,target);
		int r = findL(nums,target);
		int[] ans = {-1,-1};
		if(l!= -1){
			ans[0] = l;
			ans[1] = r;
		}
		return ans;
	}

	int findF(int[] nums,int target){
		int l = 0;
		int r = nums.length-1;
		while (l<=r){
			int m = (l+r)/2;
			if(nums[m] == target) r = m-1;
			else if(nums[m] < target) l = m+1;
			else r = m -1;
		}
		if(l != nums.length && nums[l]== target)
			return l;
		return -1;
	}
	int findL(int[] nums, int target) {
		int l = 0;
		int r = nums.length-1;
		while (l<=r){
			int m = (l+r)/2;
			if(nums[m] == target) l = m+1;
			else if(nums[m] < target) l = m+1;
			else r = m -1;
		}
		return r;
	}
}

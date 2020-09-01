package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/2 3:01
 * Remark:
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 */
public class T78 {

	public static void main(String[] args) {
		T78 t = new T78();
		int[] nums = {1,2,3};
		List<List<Integer>> ans = t.subsets2(nums);
		System.out.println(ans.toString());
	}


	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>());
		for (int i = 0; i < nums.length; i++) {
			int len = list.size();
			for (int j = 0; j < len; j++) {
				List<Integer> temp = new ArrayList<>(list.get(j));
				temp.add(nums[i]);
				list.add(temp);
			}
		}
		return list;
	}

	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		back(0,nums,res,new ArrayList<Integer>());
		return res;
	}

	void back(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> temp) {
		res.add(new ArrayList<>(temp));
		for (int j = i; j < nums.length; j++) {
			temp.add(nums[j]);
			back(j+1,nums,res,temp);
			temp.remove(temp.size()-1);
		}
	}


}

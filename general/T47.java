package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/8 7:32
 * Remark:
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class T47 {

	/*
		回溯搜索+剪枝
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		boolean[] v = new boolean[nums.length];
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		dfs(nums,v,temp,list);
		return list;
	}

	void dfs(int[] nums, boolean[] v, List<Integer> temp, List<List<Integer>> list) {
		if(temp.size() == nums.length){
			list.add(new ArrayList<>(temp));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if(!v[i]) {
				if(i>0 && nums[i-1]==nums[i] && !v[i-1]) continue;
				temp.add(nums[i]);
				v[i] = true;
				dfs(nums,v,temp,list);
				v[i] = false;
				temp.remove(temp.size()-1);
			}
		}
	}


	/*
		全排列，set去重
	 */
	public List<List<Integer>> permuteUnique1(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();
		boolean[] v = new boolean[nums.length];
		dfs1(nums,v,temp,set);
		for (List<Integer> tmp : set)
			list.add(tmp);
		return list;
	}

	void dfs1(int[] nums, boolean[] v, List<Integer> temp, Set<List<Integer>> set) {
		if(temp.size()==nums.length){
			set.add(new ArrayList<>(temp));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if(v[i]) continue;
			v[i]=true;
			temp.add(nums[i]);
			dfs1(nums,v,temp,set);
			v[i]=false;
			temp.remove(temp.size()-1);
		}
	}
}

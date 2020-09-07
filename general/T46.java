package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/8 6:59
 * Remark:
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class T46 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		int[] visited = new int[nums.length];
		dfs(nums,visited,new ArrayList<Integer>(),list);
		return list;
	}

	void dfs(int[] nums, int[] visited, ArrayList<Integer> temp, List<List<Integer>> list) {
		if(temp.size() == nums.length){
			list.add(new ArrayList<>(temp));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if(visited[i]==1) continue;
			visited[i]=1;
			temp.add(nums[i]);
			dfs(nums,visited,temp,list);
			visited[i]=0;
			temp.remove(temp.size()-1);
		}
	}


}

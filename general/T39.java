package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/9 1:37
 * Remark:
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 */
public class T39 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		int len = candidates.length;
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		dfs(candidates,target,0,list,temp);
		return list;
	}

	void dfs(int[] candidates, int target, int index, List<List<Integer>> list, List<Integer> temp) {
		if(target < 0) return;
		if(target ==0){
			list.add(new ArrayList<>(temp));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if(target < 0) break;
			temp.add(candidates[i]);
			dfs(candidates,target-candidates[i],i,list,temp);
			temp.remove(temp.size()-1);
		}
	}
}

package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/9 2:31
 * Remark:
 * 给定一个数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 */
public class T40 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		Arrays.sort(candidates);
		dfs(candidates,target,0,list,temp);
		return list;
	}

	void dfs(int[] candidates, int target, int index, List<List<Integer>> list, List<Integer> temp) {
		if(target < 0) return;
		if(target == 0){
			list.add(new ArrayList<>(temp));
			return;
		}
		for (int i = index; i < candidates.length;i++) {
			if(target<0) break;
			if(i>index && candidates[i] == candidates[i-1]) continue;
			temp.add(candidates[i]);
			dfs(candidates,target-candidates[i],i+1,list,temp);
			temp.remove(temp.size()-1);
		}
	}
}

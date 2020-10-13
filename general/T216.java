package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/11 5:56
 * Remark:找出所有相加之和为 n 的 k 个数的组合。
 * 组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 */
public class T216 {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		dfs(k,n,0,1,list,temp);
		return list;
	}

	public void dfs(int k,int n,int sum,int index,List<List<Integer>> list,List<Integer> temp){
		if(temp.size()>k || sum>n) return;
		if(temp.size()==k && sum==n){
			list.add(new ArrayList<>(temp));
			return;
		}
		for(int i=index;i<10;i++){
			temp.add(i);
			dfs(k,n,sum+i,i+1,list,temp);
			temp.remove(temp.size()-1);
		}
	}
}

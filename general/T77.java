package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/8 6:22
 * Remark:
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class T77 {

	public static void main(String[] args) {
		T77 t = new T77();
		int n = 4;
		int k = 2;
		List<List<Integer>> ans = t.combine(n,k);
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		dfs(n,k,1,temp,list);
		return list;
	}

	public void dfs(int n,int k,int index,List<Integer> temp,List<List<Integer>> list){
		if(temp.size() == k){
			list.add(new ArrayList<>(temp));
			System.out.println(temp);
			return;
		}

		for (int i = index; i <= n-(k-temp.size())+1; i++) {
//		for (int i = index; i <= n; i++) {
			temp.add(i);
			dfs(n,k,i+1,temp,list);
			temp.remove(temp.size()-1);
		}
	}
}

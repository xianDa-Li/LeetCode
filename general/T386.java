package com.company.leetcode.general;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: XianDaLi
 * Date: 2020/8/22 10:22
 * Remark:
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 */
public class T386 {

	public List<Integer> lexicalOrder(int n) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			dfs(n,i,list);
		}
		return list;
	}
	public void dfs(int n,int i,List<Integer> list){
		if(i > n) return;
		list.add(i);
		i*=10;
		for (int j = 0; j < 10 ; j++) {
			dfs(n,i+j,list);
		}
	}


	/*
	List<Integer> list = new ArrayList<>();
	public List<Integer> lexicalOrder(int n){
		dfs(n,0,0);
		return list;
	}
	public void dfs(int max,int num,int start){
		if(num > max)
			return;
		if(num > 0)
			list.add(num);
		for (int i = start > 0 ? 0 : 1; i <=9 ; i++) {
			dfs(max,num*10+i,start+1);
		}
	}
	 */

}

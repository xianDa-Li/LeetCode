package com.company.leetcode.offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: XianDaLi
 * Date: 2020/8/23 19:22
 * Remark:
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class O38 {
	/*
		思路：字典树
		时间O(n!)
		空间O(n^2)
	 */
	List<String> ans = new LinkedList<>();
	char[] c;
	public String[] permutation(String s) {
		c = s.toCharArray();
		dfs(0);
		return ans.toArray(new String[ans.size()]);
	}

	void dfs(int x){
		if(x == c.length-1){
			ans.add(String.valueOf(c));
			return;
		}
		HashSet<Character> set = new HashSet<>();
		for (int i = x; i < c.length; i++) {
			if(set.contains(c[i])) continue;
			set.add(c[i]);
			swap(1,x);
			dfs(x+1);
			swap(i,x);
		}
	}

	void swap(int a,int b){
		char temp = c[a];
		c[a] = c[b];
		c[b] = temp;
	}
}

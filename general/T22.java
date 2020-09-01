package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/1 16:12
 * Remark:
 */
public class T22 {
	public static void main(String[] args) {
		int n = 3;
		T22 t = new T22();
		List<String> ans = t.generateParenthesis(n);
		System.out.println(ans);
	}
	List<String> list = new ArrayList<>();
	public List<String> generateParenthesis(int n) {
		StringBuilder sb = new StringBuilder();
		dfs(n,n,"");
		return list;
	}
	void dfs(int l,int r,String s){
		if(l == 0 && r == 0){
			list.add(s);
			return;
		}
		if(l>0) dfs(l-1,r,s+"(");
		if(r>l) dfs(l,r-1,s+")");
	}
}

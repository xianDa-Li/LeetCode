package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/8 7:57
 * Remark:
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 */
public class T784 {

	public List<String> letterCasePermutation(String S) {
		List<String> list = new ArrayList<>();
		dfs(S.toCharArray(),0,list);
		return list;
	}

	void dfs(char[] s, int i, List<String> list) {
		for(;i<s.length;i++){
			if(s[i] >= 'A'){
				s[i] = (char)(s[i]^(1<<5)); // 可用32 代替1<<5
				dfs(s,i+1,list);
				s[i] = (char)(s[i]^32);
			}
		}
		list.add(new String(s));
	}

	public List<String> letterCasePermutation1(String S) {
		List<String> list = new ArrayList<>();
		dfs1(S.toCharArray(),0,list);
		return list;
	}

	void dfs1(char[] s, int i, List<String> list) {
		for(;i<s.length;i++){
			if(s[i] >= 'a' && s[i] <= 'z'){
				s[i] = (char)(s[i]-'a'+'A');
				dfs1(s,i+1,list);
				s[i] = (char)(s[i]-'A'+'a');
			}
			if(s[i] >= 'A' && s[i] <= 'Z'){
				s[i] = (char)(s[i]-'A'+'a');
				dfs1(s,i+1,list);
				s[i] = (char)(s[i]-'a'+'A');
			}
		}
		list.add(new String(s));
	}


	public List<String> letterCasePermutation2(String S) {
		int len = S.length();
		List<String> list = new ArrayList<>();
		if(len==0) return list;
		char[] s = S.toCharArray();
		dfs2(S,0,len,s,list);
		return list;
	}

	void dfs2(String S, int index, int len, char[] s, List<String> list) {
		if(index == len){
			list.add(new String(s));
			return;
		}
		s[index] = S.charAt(index);
		dfs2(S,index+1,len,s,list);
		if(Character.isLetter(S.charAt(index))){
			s[index] = (char)(S.charAt(index) ^ (1<<5));
			dfs2(S,index+1,len,s,list);
		}
	}
}

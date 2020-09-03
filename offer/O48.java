package com.company.leetcode.offer;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/2 22:33
 * Remark:
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class O48 {
	/*
		方法一：动态规划+哈希表
		时间O(n)
		空间O(1)
	 */
	public int lengthOfLongestSubstring(String s) {
		Map<Character,Integer> map = new HashMap<>();
		int max = 0;
		int temp = 0;
		for (int i = 0; i < s.length(); i++) {
			int j = -1;
			if(map.containsKey(s.charAt(i))){
				j = map.get(s.charAt(i)); // 获取索引
			}
			map.put(s.charAt(i),i); // 更新哈希表
			temp = temp < i-j ? temp+1 : i-j; // dp[j-1]->dp[j]
			max = Math.max(max,temp); // max(dp[j - 1], dp[j])
		}
		return max;
	}

	/*
	方法二：哈希表+双指针
	时间O(n)
	空间O(1)
	 */
	public int lengthOfLongestSubstring2(String s) {
		Map<Character,Integer> map = new HashMap<>();
		int max = 0;
		int l = -1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(map.containsKey(c))
				l = Math.max(l,map.get(c));
			map.put(c,i);
			max = Math.max(i-l,max);
		}
		return max;
	}

}

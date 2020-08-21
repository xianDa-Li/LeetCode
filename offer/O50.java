package com.company.leetcode.offer;

/**
 * Author: XianDaLi
 * Date: 2020/8/18 10:32
 * Remark:
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class O50 {
	/*
	思路：用一个数组保存字符串中每个字母出现的次数，
	因为只含有小写字母，所以数组大小为26即可.
	首先一次遍历，遇到当前字符时，就在该字符所对应的位置+1.
	最后再一次遍历，当该元素所对应的数组元素为1时(该字符出现次数)，
	直接返回该字符，若遍历完都没找到出现1次的，则返回' '
		时间O(n)
		空间O(n)
	 */
	public char firstUniqChar(String s) {
		int[] nums = new int[26];
		for(char c : s.toCharArray()){
			nums[c-'a']++;
		}
		for(char c : s.toCharArray()){
			if(nums[c -'a'] == 1)
				return c;
		}
		return ' ';
	}

}

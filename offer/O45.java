package com.company.leetcode.offer;

import java.util.Arrays;

/**
 * Author: XianDaLi
 * Date: 2020/8/23 9:55
 * Remark:
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 */
public class O45 {
	/*
		把数组按照字典序排序好输出即可
		重写快排
		时间O(nlogn)
		空间O(n)
	 */
	public String minNumber(int[] nums) {
		String[] ss = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			ss[i] = String.valueOf(nums[i]);
		}
		sort(ss,0,ss.length-1);
		StringBuilder sb = new StringBuilder();
		for (String s: ss) {
			sb.append(s);
		}
		return sb.toString();
	}

	private void sort(String[] ss, int l, int r) {
		if(l>=r) return;
		int i = l;
		int j = r;
		String p = ss[i];
		while (i < j){
			while ((ss[j] + ss[l]).compareTo(ss[l] + ss[j]) >= 0 && i < j) j--;
			while ((ss[i] + ss[l]).compareTo(ss[l] + ss[i]) <= 0 && i < j) i++;
			p = ss[i];
			ss[i] = ss[j];
			ss[j] = p;
		}
		ss[i] = ss[l];
		ss[l] = p;
		sort(ss,l,i-1);
		sort(ss,i+1,r);
	}
	/*
	对内置快排重新定义构造器
	 */
	public String minNumber2(int[] nums) {
		String[] ss = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			ss[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(ss,(x,y)->(x+y).compareTo(y+x)); // 重新定义构造器
		StringBuilder sb = new StringBuilder();
		for (String s: ss) {
			sb.append(s);
		}
		return sb.toString();
	}

}

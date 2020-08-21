package com.company.leetcode.offer;

/**
 * Author: XianDaLi
 * Date: 2020/8/22 2:47
 * Remark:给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 */
public class O66 {
	/*
	题意大概是，b[i]的值是数组a中除了下标i以外的元素的积
	那么就把b从b[i]分成上下两部分算，前部分b[0]乘到b[i-1],后半段b[i+1]乘到b[n]
	时间O(n)
	空间O(1)
	 */
	public int[] constructArr(int[] a) {
		int n = a.length;
		if(n == 0) return null;
		int[] b = new int[n];
		b[0] = 1;               // 初始化b[0] = 1; 否则初始化的b[0]=0会导致怎么乘结果都是0
		int temp = 1;
		for (int i = 1; i < n; i++) {   // 前部分 ,类似于前缀和概念的前缀积
			b[i] = b[i-1] * a[i-1];
		}
		for (int i = n-2; i >=0 ;i--) { // 后部分，同理
			temp *= a[i+1];
			b[i] *= temp;
		}
		return b;
	}
}

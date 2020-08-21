package com.company.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: XianDaLi
 * Date: 2020/8/18 0:33
 * Remark:0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 */
public class O62 {

	public static void main(String[] args) {
		int m = 5;
		int n = 3;

		System.out.println(2%5);
	}

	/*
	方法一：数学反推
	时间O(n)
	空间O(1)
	 */
	public static int lastRemaining(int n, int m){
		int ans = 0;
		for (int i = 2; i <= n ; i++) {  //最后一轮剩下2个人 所以从2开始反推
			ans = (ans + m) % i;
		}
		return ans;
	}

	/*
	方法二：数学+递归
	 */
	public static int lastRemaining2(int n, int m){
		return res(n,m);
	}
	public static int res(int n,int m){
		if(n==1) return 0;
		int x = res(n-1,m);
		return (m+x) % n;
	}

	/*
	方法三：模拟链表
	时间O(n^2)
	空间O(n)
	 */
	public static int lastRemaining3(int n, int m){
		if(n==1) return n;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		int index = 0;
		while (n>1){
			index = (index + m-1) % n;
			list.remove(index);
			n--;
		}
		return list.get(0);
	}
}

package com.company.leetcode.offer;

/**
 * Author: XianDaLi
 * Date: 2020/8/29 22:50
 * Remark:
 * 青蛙跳台阶问题
 */
public class O10_2 {
	/**
	 * 很经典的青蛙跳台阶问题，动态规划的模板类问题。
	 * 首先青蛙一次能跳1也能跳2，那么青蛙跳上n时，就是n-1和n-2跳上来的方式和，
	 * 即有方程dp[n]=dp[n-1]+dp[n-2]
	 * 然后设置好dp[0]=1,dp[1]=1; 跳第1层只能一种方法
	 * 为啥dp[0]=1? 因为给的示例n=0时输出的是1 :)
	 * 空间O(n) 用了一个数组
	 * 时间O(n) 遍历一次
	 * 动态规划我认为大体还是基于空间换时间的理念
	 * 而设置好方程是动归的核心
	 */
	public int numWays(int n) {
		if(n<=1) return 1;
		int[] dp = new int[n+1];
		dp[0]=1;
		dp[1]=1;
		for (int i = 2; i <=n ; i++) {
			dp[i] = (dp[i-1]+dp[i-2])%1000000007;
		}
		return dp[n];
	}
}

package com.company.leetcode.general;

/**
 * Author: XianDaLi
 * Date: 2020/9/2 2:37
 * Remark:
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class T70 {
	/**
	 * 时间O(n)
	 * 空间O(n)
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		int[] dp = new int[n+1];
		dp[0]=1;
		dp[1]=1;
		for (int i = 2; i <=n; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
}

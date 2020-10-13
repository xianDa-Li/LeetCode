package com.company.leetcode.general;

/**
 * Author: XianDaLi
 * Date: 2020/10/11 13:05
 * Remark:给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
 * 现在你有两个符号 + 和 -。对于数组中的任意一个整数，
 * 你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 */
public class T494 {
	public int findTargetSumWays(int[] nums, int S) {
		int sum = 0;
		for(int num : nums){
			sum += num;
		}
		if(sum < S || (sum+S) % 2 == 1){
			return 0;
		}
		int w = (sum + S)/2;
		int[] dp = new int[w+1];
		dp[0] = 1;
		for (int num : nums) {
			for (int i = w; i >= num; i--) {
				dp[i] += dp[i - num];
			}
		}
		return dp[w];
	}
}

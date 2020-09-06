package com.company.leetcode.offer;

/**
 * Author: XianDaLi
 * Date: 2020/9/7 4:57
 * Remark:
 */
public class O60 {
	/*
		P (k)=k出现的次数/总次数
		投掷 n 个骰子，所有点数出现的总次数是 6^n，因为一共有 n 枚骰子，每枚骰子的点数都有 6 种可能出现的情况。
		避免重复计算
	 */
	public double[] twoSum(int n) {
		int pointNum = 6 * n;
		double totalNum = Math.pow(6,n);
		int[][] dp = new int[n+1][pointNum+1];

		for (int i = 1; i <= 6 ; i++)
			dp[1][i]=1;

		for (int i = 2; i <= n; i++) {
			for (int j = i; j <= pointNum; j++) {
				for (int k = 1; k <= 6; k++) {
					if(j-k <= 0) break;
					dp[i][j] += dp[i-1][j-k];
				}
			}
		}
		double[] res = new double[n*5+1];
		int index = 0;
		for (int i = n; i <= pointNum; i++)
			res[index++] = dp[n][i]/totalNum;

		return res;
	}
}

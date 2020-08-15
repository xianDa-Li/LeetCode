package com.company.leetcode.offer;

/**
 * Author: XianDaLi
 * Date: 2020/8/16 5:25
 * Remark:在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 */
public class O47 {
	/*
	方法:标准的dp模板问题，每一轮取最大值。dp[i][j]为在该坐标上获得礼物的最大值，
	上一步只会从dp[i-1][j]和dp[i][j-1]走过来，取最大值再加上当前坐标grid[i-1][j-1]即可。
	因为dp开的数组会多一排，所以原数组当前坐标为grid[i-1][j-1]而非grid[i][j]
	时间O(n*m)
	空间O(n*m)
	 */
	public int maxValue(int[][] grid) {
		int len1 = grid.length;
		int len2 = grid[0].length;
		int[][] dp = new int[len1+1][len2+1];
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
			}
		}
		return dp[len1][len2];
	}
}

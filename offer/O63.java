package com.company.leetcode.offer;

/**
 * Author: XianDaLi
 * Date: 2020/8/16 5:49
 * Remark:假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class O63 {
	/*
		思路：一个数保存最大值，一个数保存最小值
		最大值取之前的最大值ans 和 当天卖出股票的获利值prices[i]-min中的最大值;
		最小值取当前最小值 和 当天股票价格prices[i]中的最小值
		时间O(n)
		空间O(1)
	 */
	public int maxProfit(int[] prices) {
		if(prices.length < 2) return 0;
		int ans = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length ; i++) {
			ans = Math.max(ans,prices[i]-min);
			min = Math.min(min,prices[i]);
		}
		return ans;
	}
}

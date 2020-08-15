package com.company.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: XianDaLi
 * Date: 2020/8/14 16:23
 * Remark:一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class O56 {
	/*
		思路：同136题，那题只找出一个数，这道题需要找出两个数，
		方法同样用位运算,关键要把两个数字分成不同的组，
		随便取一个：取的那一位是0分成一组，那位是1分成一组
		假设数组异或的二进制结果为10010，那么说明这两个数从右向左数第2位是不同的
		那么可以根据数组里面所有数的第二位为0或者1将数组划分为2个。
		时间O(n)
		空间O(1)
	 */
	public int[] singleNumbers(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length ; i++) {
			sum ^= nums[i];
		}
		int n = 1;
		while ((sum & n)==0)
			n <<= 1;

		//找1过程可用下面的替代
//		int n = sum&(-sum);

		int a=0,b=0;
		for (int i = 0; i <nums.length ; i++) {
			if((nums[i] & n) == 0) a^=nums[i];
			else b^=nums[i];
		}
		return new int[]{a,b};
	}
}

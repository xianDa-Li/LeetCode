package com.company.leetcode.offer;

/**
 * Author: XianDaLi
 * Date: 2020/9/7 7:53
 * Remark:
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 */
public class O51 {
	public static void main(String[] args) {
		int[] nums = {7,5,6,4};
		int ans = reversePairs2(nums);
		System.out.println(ans);
	}

	public int reversePairs(int[] nums){
		int len = nums.length;
		if(len < 2) return 0;
		int[] copy = new int[len];
		for (int i = 0; i < len; i++)
			copy[i]=nums[i];
		int[] temp = new int[len];
		return reversePairs(copy,0,len-1,temp);
	}

	int reversePairs(int[] copy, int l, int r, int[] temp) {
		if(l == r) return 0;

		int m = (l+r)/2;
		int left = reversePairs(copy,l,m,temp);
		int right = reversePairs(copy,m+1,r,temp);

		if(copy[m] <= copy[m+1])
			return left + right;

		int sum = mergeSort(copy,l,m,r,temp);
		return left+right+sum;
	}

	int mergeSort(int[] copy, int l, int m, int r, int[] temp) {
		for (int i = l; i <= r ; i++)
			temp[i]=copy[i];

		int i = l;
		int j = m+1;

		int count = 0;
		for (int k = l; k <= r; k++) {
			if(i == m+1){
				copy[k]=temp[j];
				j++;
			}else if(j == r+1){
				copy[k] = temp[i];
				i++;
			}else if(temp[i] <= temp[j]){
				copy[k] = temp[i];
				i++;
			}else {
				copy[k] = temp[j];
				j++;
				count += (m-i+1);
			}
		}
		return count;
	}


	/*
		暴力枚举(超时)
	 */
	public static int reversePairs2(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(nums[i] > nums[j]) count++;
			}
		}
		return count;
	}
}

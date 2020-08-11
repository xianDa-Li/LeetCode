package com.company.leetcode.offer;

import java.util.PriorityQueue;
import java.util.Queue;

public class O40 {

	/*
	剑指 Offer 40. 最小的k个数
		输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
	 */
	public static void main(String[] args) {
		int[] arr = {3,2,1};
		int k = 2;
		int[] ans = getLeastNumbers(arr,2);
		for(int i:ans){
			System.out.println(i);
		}
	}
	public static int[] getLeastNumbers(int[] arr, int k) {
		Queue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<arr.length;i++){
			pq.add(arr[i]);
		}
		int[] ans = new int[k];
		for(int i=0;i<k;i++){
			ans[i] = pq.poll();
		}
		return ans;
	}
}

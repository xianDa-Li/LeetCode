package com.company.leetcode.offer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class O40 {

	/*
	剑指 Offer 40. 最小的k个数
		输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
	 */
	public static void main(String[] args) {
		O40 o40 = new O40();
		int[] arr = {3,2,1};
		int k = 2;
		int[] ans = o40.getLeastNumbers(arr,2);
		for(int i:ans){
			System.out.println(i);
		}
	}

	/*
		方法一：快排
		在原数组上使用快速排序将数组排序，之后取出前K个数即可
		时间O(nlogn)
		空间O(logn )
	 */
	public  int[] getLeastNumbers(int[] arr, int k) {
		int l = 0;
		int r = arr.length-1;
		quickSort(arr,l,r);
		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			ans[i] = arr[i];
		}
		return ans;
	}
	public void quickSort(int[] arr,int l,int r){
		if (l < r) {
			int p = res(arr,l,r); // 设置基准点
			quickSort(arr,l,p-1); // 左区间
			quickSort(arr,p+1,r); // 右区间
		}
	}
	public int res(int[] arr,int l,int r){
		int p = arr[l];
		while (l<r){
			while (l<r && arr[r]>=p) r--; // 移动右边的下标 找到比基准点小的数
			arr[l] = arr[r];              // 找到后便把该数移动到p左边
			while (l<r && arr[l]<=p) l++; // 移动左边的下标，找到比基准点大的数
			arr[r] = arr[l];              // 找到后便把该数移动到p右边
		}
		arr[l] = p;
		return l;
	}
	/*
		方法二：堆排序
		创建一个最小堆(java中默认就是最小堆)，一次遍历将数组全部数据放入
		二次遍历取出前k个数即可
		时间O(nlogn)
		空间O(n)
	 */

	public static int[] getLeastNumbers2(int[] arr, int k) {
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

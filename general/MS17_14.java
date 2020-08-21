package com.company.leetcode.general;

/**
 * Author: XianDaLi
 * Date: 2020/8/20 10:21
 * Remark:
 *设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 */
public class MS17_14 {
	// 标准快排模板
	public int[] smallestK(int[] arr, int k) {
		int[] ans = new int[k];
		quickSort(arr,0,arr.length-1);
		for(int i=0;i<k;i++){
			ans[i] = arr[i];
		}
		return ans;
	}

	public void quickSort(int[] arr,int s,int e){
		if(s > e) return;
		int l = s; //左指针
		int r = e; //右指针
		int p = arr[s]; // 获取第一个元素为基准数
		while(l != r){ // 只要左右指针不重合便继续移动 直到所有元素交换完成
			// 右指针开始移动，找到比基准数小的就停止
			while(arr[r]>p &&  l<r){
				r--;
			}
			// 左指针开始移动，找到比基准大的就停止
			while(arr[l]<=p && l<r){
				l++;
			}
			//都停止后便交换位置
			if(l < r){
				int temp = arr[r];
				arr[r] = arr[l];
				arr[l] = temp;
			}
		}

		// 一轮交换结束后，把基准数从第一位移动到左右指针重合位置
		int t = arr[l];
		arr[l] = arr[s];
		arr[s] = t;
		quickSort(arr,s,r-1); // 左边递归
		quickSort(arr,l+1,e); // 右边递归
	}
}

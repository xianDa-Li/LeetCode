package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/8/12 8:54
 * Remark:
 */
public class T1481 {
	/*
	方法一
		思路：
			将arr[i]为键，出现的次数为value放进hashMap,然后将value放进一个val数组中，
			最后用k依次减去val[i],当k-val[i] < 0的时候，输出val下标val.length-i;
		时间O(nlogn) 虽然都是单次遍历，但因为有Arrays.sort(val)的存在，所以时间为nlogn
		空间O(n)

	 */
	public static int findLeastNumOfUniqueInts(int[] arr, int k) {
		Map<Integer,Integer> hm = new HashMap<>();
		for(int i=0;i<arr.length;i++){
			if(hm.containsKey(arr[i])){
				hm.replace(arr[i],hm.get(arr[i])+1);
			}
			else
			{
				hm.put(arr[i],1);
			}
		}
		if(k==0) return hm.size();              //如果k为0直接返回所有不同整数个数
		int[] val = new int[hm.size()];
		int a=0;
		for(int key:hm.keySet()){
			val[a++] = hm.get(key);
		}

		Arrays.sort(val);                       //排序后即可从小到大依次用K来减
		int i = 0;
		for(i=0;i<val.length;i++){
			if(k-val[i]>=0){
				k = k-val[i];
			}
			else break;
		}
		return val.length - i;                   //返回被k减后剩余的不同整数个数
	}
	/*
	方法二
		在Arrays.sort的位置，不使用快排，单独开辟一个最小堆来存储本来val数组中的数据。
		取出时也依次取出即可，我认为时间和空间应该都是比方法一少，但实际花费了更多的空间和时间，应该是和堆的存取有关。
	 */
	public static int findLeastNumOfUniqueInts2(int[] arr, int k) {
		Map<Integer,Integer> hm = new HashMap<>();
		for(int i=0;i<arr.length;i++){
			if(hm.containsKey(arr[i])) hm.replace(arr[i],hm.get(arr[i])+1);
			else hm.put(arr[i],1);
		}
		if(k==0) return hm.size();
		Queue<Integer> val = new PriorityQueue<>();             // 用堆来保存方法一中val数组中的数据
		for(int key:hm.keySet()){
			val.add(hm.get(key));
		}
		while (k>=0 && !val.isEmpty()){                         // 依次删除堆顶即可
			if(k >= val.peek())k -= val.poll();
			else break;
		}
		return val.size();
	}

	public static void main(String[] args) {
		int[] arr = {5,5,4};
		int k = 1;
		int ans = findLeastNumOfUniqueInts(arr,k);
		System.out.println(ans);
	}

}

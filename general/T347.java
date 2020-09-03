package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/2 11:46
 * Remark:
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素
 */
public class T347 {

	public int[] topKFrequent(int[] nums, int k) {
		if(nums.length == 1) return nums;
		if(nums.length == 0) return null;

		Map<Integer,Integer> map = new HashMap<>();
		for (int num : nums) {
			if(map.containsKey(num))
				map.put(num,map.get(num)+1);
			else map.put(num,1);
		}
		//更改构造器，由 由a,b判断的大顶堆更改为 由map.get(a)和map.get(b)判断的大顶堆
		PriorityQueue<Integer> pq = new PriorityQueue<>(
				(a,b)->map.get(a)-map.get(b)
		);

		for (int key : map.keySet()) {
			if(pq.size()<k)
				pq.add(key);
			else if(map.get(key)>map.get(pq.peek())){
				pq.remove();
				pq.add(key);
			}
		}
		int[] ans = new int[k];
		int index = 0;
		while (!pq.isEmpty()){
			ans[index++] = pq.poll();
		}
		return ans;
	}
}

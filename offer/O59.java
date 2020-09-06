package com.company.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author: XianDaLi
 * Date: 2020/9/1 0:40
 * Remark:
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class O59 {
	/*
		单调队列
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length == 0) return new int[0];
		int[] ans = new int[nums.length-k+1];
		Deque<Integer> queue = new ArrayDeque<>();
		for (int i = 0,j=0; i < nums.length; i++) {
			if(!queue.isEmpty() && i-queue.peek() >= k)
				queue.poll();
			while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()])
				queue.pollLast();
			queue.offer(i);
			if(i >= k-1)
				ans[j++] = nums[queue.peek()];
		}
		return ans;
	}



	/*
	双指针
	 */
	public int[] maxSlidingWindow2(int[] nums, int k) {
		if(nums.length == 0) return new int[0];
		int[] ans = new int[nums.length];
		int l = 0;
		int r = k;
		while (r<=nums.length){
			int max = nums[l];
			for (int i = l; i<r; i++) {
				max = Math.max(max,nums[l]);
			}
			ans[l] = max;
			l++;
			r = l+k;
		}
		return ans;
	}
}

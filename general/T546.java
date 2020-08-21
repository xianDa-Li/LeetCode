package com.company.leetcode.general;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author: XianDaLi
 * Date: 2020/8/15 1:14
 * Remark:给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。
 * 你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。
 * 每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k*k 个积分。
 * 当你将所有盒子都去掉之后，求你能获得的最大积分和
 */
public class T546 {
	public int removeBoxes(int[] boxes) {
		/*int ans = 0,row = 0;
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < boxes.length; i++) {
			int count = 1;
			if (!stack.isEmpty()&& stack.peek()==boxes[i]){
				stack.poll();
				count++;
			}else {
				stack.push(boxes[i]);
				count--;
			}
			count*=count;
			ans += count;
		}
		return ans;*/
		return 0;
	}
}

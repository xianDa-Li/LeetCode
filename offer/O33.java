package com.company.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;


/**
 * Author: XianDaLi
 * Date: 2020/8/14 2:21
 * Remark:输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class O33 {
	/*
		方法一：单调栈辅助遍历树
		思路：
			二叉搜索树：左节点<根节点<右节点
			后序遍历：左节点->右节点->根节点
			后序遍历的倒叙即为 根节点->右节点->左节点
		时间O(n)
	    空间O(n)
	 */
	public boolean verifyPostorder(int[] postorder) {
		int len = postorder.length;
		int mid = Integer.MAX_VALUE;
		Deque<Integer> stack = new LinkedList<>();
		for (int i = len-1; i >= 0; i--) {
			if(postorder[i] > mid) return false;
			while (!stack.isEmpty() && stack.peek() > postorder[i])
				mid = stack.poll();
			stack.push(postorder[i]);
		}
		return true;
	}

	/*
		方法二：递归
		思路：
			递归判断每一棵子树是否都满足条件
		时间O(n^2)
		空间O(n)
	 */
	public boolean verifyPostorder2(int[] postorder) {
		return res(postorder,0,postorder.length-1);
	}

	private boolean res(int[] postorder, int i, int j) {
		if(i >= j) return true;
		int temp = i;
		while (postorder[temp] < postorder[j]) temp++;  // 左子树
		int m = temp;
		while (postorder[temp] > postorder[j]) temp++;  // 右子树
		return temp == j && res(postorder,i,m-1) && res(postorder,m,j-1);
	}
}

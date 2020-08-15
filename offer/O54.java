package com.company.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: XianDaLi
 * Date: 2020/8/14 11:34
 * Remark:
 */
public class O54 {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	/*
		方式一：反方向中序遍历 右->中->左
		时间O(n)
		空间O(n)
	 */
	List<Integer> list = new ArrayList<>();
	public int kthLargest(TreeNode root, int k) {
		Tree(root);
		return list.get(k-1);
	}

	public void Tree(TreeNode root){
		if(root == null) return;
		Tree(root.right);
		list.add(root.val);
		Tree(root.left);
	}
	/*
		方式二:优化中序遍历 得到K大的数时可直接返回
		时间O(n)
		空间O(1)
	 */
	int ans = 0, count = 0;
	public int kthLargest2(TreeNode root, int k) {
		Tree2(root,k);
		return ans;
	}
	void Tree2(TreeNode root,int k){
		if(root.right != null) Tree2(root.right,k);
		if(++count == k){
			ans = root.val;
			return;
		}
		if(root.left != null) Tree2(root.left,k);
	}
}

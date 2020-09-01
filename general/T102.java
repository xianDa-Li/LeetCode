package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/2 2:42
 * Remark:
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class T102 {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if(root == null) return list;
		Queue<TreeNode> queue = new LinkedList<>();
		if(root != null) {
			queue.add(root);
		}
		while (!queue.isEmpty()){
			int n = queue.size();
			List<Integer> t = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				TreeNode temp = queue.poll();
				t.add(temp.val);
				if(temp.left != null){
					queue.add(temp.left);
				}
				if(temp.right != null) {
					queue.add(temp.right);
				}
			}
			if(t.size() != 0)list.add(t);
		}
		return list;
	}

	void dfs(TreeNode root){
		if(root == null) return;
		dfs(root.left);
		dfs(root.right);
	}
}

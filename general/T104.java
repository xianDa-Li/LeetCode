package com.company.leetcode.general;


/**
 * Author: XianDaLi
 * Date: 2020/8/17 8:27
 * Remark:给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class T104 {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	//方法一
	public int maxDepth(TreeNode root){
		if(root == null) return 0;
		int left =  maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left,right)+1;
	}

	int max = 0;
	public int maxDepth2(TreeNode root){
		if(root == null) return 0;
		dfs(root,1);
		return max;
	}
	public void dfs(TreeNode root,int n){
		if(root == null) return;
		max = n > max ? n : max;
		dfs(root.left,n+1);
		dfs(root.right,n+1);
	}

}

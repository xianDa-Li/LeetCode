package com.company.leetcode.offer;


/**
 * Author: XianDaLi
 * Date: 2020/8/17 22:26
 * Remark:给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先.
 * 对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 */
public class O68_1 {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}

	/*
	方法一：递归
	时间O(n)
	空间O(n)
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return null;
		if(root.val > p.val && root.val > q.val)
			return lowestCommonAncestor(root.left,p,q);
		if(root.val < p.val && root.val < q.val)
			return lowestCommonAncestor(root.right,p,q);
		return root;
	}
	/*
	方法二：迭代
	时间O(n)
	空间O(n)
	 */
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		while (root != null){
			if(root.val > p.val && root.val > q.val)
				root = root.left;
			else if(root.val < p.val && root.val < q.val)
				root = root.right;
			else break;
		}
		return root;
	}
}

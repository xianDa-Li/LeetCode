package com.company.leetcode.offer;

/**
 * Author: XianDaLi
 * Date: 2020/8/17 21:45
 * Remark:给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class O68_2 {

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	/*
		返回值四种情况:
			1.当left和right都为空：说明root的左右子树中都不包含oq 返回null;
			2.当left和right同时不为空：说明p,q分别在root的左右子树中，因此root为最近公共祖先.
			3.当left为空right不为空：p,q都不存在于左子树。直接返回right
				1.p,q其中一个在root右子树中，此时指向p或q
				2.p,q都在root右子树中，此时right 为最近公共祖先节点
		时间O(n)
		空间O(n)
	*/
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) return root;
		TreeNode left = lowestCommonAncestor(root.left,p,q);
		TreeNode right = lowestCommonAncestor(root.right,p,q);
		if(left == null && right == null) return null; // 1 (可省略，如果成立,则第一行root返回的也是null)
		if(left == null) return right; // 3
		if(right == null) return left; // 4
		return root; // 2
	}

}

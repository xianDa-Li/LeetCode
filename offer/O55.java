package com.company.leetcode.offer;

/**
 * Author: XianDaLi
 * Date: 2020/8/22 4:22
 * Remark:输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class O55 {

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val){
			this.val = val;
		}
	}

	/*
		时间O(nlogn)
		空间O(n)
	*/
	public boolean isBalanced(TreeNode root) {
		return res2(root) != -1;
	}
	public int res2(TreeNode root){
		if(root == null) return 0;
		int left = res2(root.left);
		if(left == -1) return -1;
		int right = res2(root.right);
		if(right == -1) return -1;
		return Math.abs(left-right) < 2 ? Math.max(left,right)+1 : -1;
	}

	/*
		1.判断 当前子树 是否是平衡树
		2.判断 当前子树左子树 是否是平衡树
		3.判断 当前子树右子树 是否是平衡树
		时间O(nlogn)
		空间O(n)
	 */
	public boolean isBalanced2(TreeNode root) {
		if(root == null) return true;
		if(Math.abs(res(root.left) - res(root.right)) <= 1)
			return isBalanced2(root.left) && isBalanced2(root.right);
		return false;
	}
	public int res(TreeNode root){
		if(root == null) return 0;
		return Math.max(res(root.left),res(root.right)) + 1;
	}
}

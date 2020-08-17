package com.company.leetcode.general;

/**
 * Author: XianDaLi
 * Date: 2020/8/17 7:50
 * Remark:
 */
public class T110 {

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}

	}
	public boolean isBalanced(TreeNode root) {
		return height(root) != -1;
	}

	public int height(TreeNode root) {
		if(root == null) return 0;
		int left = height(root.left);
		if(left == -1) return -1;
		int right = height(root.right);
		if(right == -1) return -1;
		return Math.abs(left-right) < 2 ? Math.max(left,right)+1 : -1;
	}



	/*
	方法二：从顶至底
	时间O(n^2)
	空间O(n)
	public boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		else return Math.abs(getCount(root.left)-getCount(root.right)) < 2
				&& isBalanced(root.left) && isBalanced(root.right);

	}

	public int getCount(TreeNode root){
		if(root == null) return 0;
		else return Math.max(getCount(root.left),getCount(root.right))+1;
	}
	*/
}

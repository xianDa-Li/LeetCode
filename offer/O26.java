package com.company.leetcode.offer;

/*
	题目要求：
		输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
		B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */


public class O26 {
	//一个树的结构
	private class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	/*
	若树 B 是树 A 的子结构，则必满足以下三种情况之一，因此用或 || 连接；
	以 节点 A 为根节点的子树 包含树 B ，对应 recur(A, B)；
	树 B 是 树 A 左子树 的子结构，对应 isSubStructure(A.left, B)；
	树 B 是 树 A 右子树 的子结构，对应 isSubStructure(A.right, B)；

	 */
	public boolean isSubStructure(TreeNode A,TreeNode B){
		if(A == null || B == null) return false;
		return dfs(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
	}

	/*
	终止条件:
		当节点 B 为空：说明树 B 已匹配完成（越过叶子节点），因此返回 truetrue ；
		当节点 A 为空：说明已经越过树 A 叶子节点，即匹配失败，返回 falsefalse ；
		当节点 A 和 B 的值不同：说明匹配失败，返回 falsefalse ；
	返回值:
		判断A和B的左子节点是否相等，即dfs(A.left,B.left);
		判断A和B的右子节点是否相等，即dfs(A.right,A.right);

	 */
	public boolean dfs(TreeNode A,TreeNode B){
		if(B == null) return true;
		if(A == null || A.val != B.val) return false;
		return dfs(A.left,B.left) && dfs(A.right,B.right);
	}
}

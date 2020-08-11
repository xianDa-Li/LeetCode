package com.company.leetcode.offer;

/*
做递归思考三步：
	1.递归的函数要干什么？
		函数的作用是判断传入的两个树是否镜像。
		输入：TreeNode left, TreeNode right
		输出：是：true，不是：false
	2.递归停止的条件是什么？
		左节点和右节点都为空 -> 倒底了都长得一样 ->true
		左节点为空的时候右节点不为空，或反之 -> 长得不一样-> false
		左右节点值不相等 -> 长得不一样 -> false
	3.从某层到下一层的关系是什么？
		要想两棵树镜像，那么一棵树左边的左边要和二棵树右边的右边镜像，一棵树左边的右边要和二棵树右边的左边镜像
		调用递归函数传入左左和右右
		调用递归函数传入左右和右左
		只有左左和右右镜像且左右和右左镜像的时候，我们才能说这两棵树是镜像的
	4.调用递归函数，我们想知道它的左右孩子是否镜像，传入的值是root的左孩子和右孩子。这之前记得判个root==null。
 */

// 树的构造

public class O28 {
	private class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		return dfs(root.left,root.right);
	}

	public boolean dfs(TreeNode left, TreeNode right) {
		if(left == null && right == null) return true;
		if(left == null && right !=null) return false;
		if(left != null && right ==null) return false;
		if(left.val != right.val) return false;
		return dfs(left.left,right.right) && dfs(left.right,right.left);
	}
}

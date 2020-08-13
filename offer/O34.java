package com.company.leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: XianDaLi
 * Date: 2020/8/14 4:02
 * Remark:输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */
public class O34 {
	/*
		思路:
			DFS遍历每条路径，找到每条符合的路径，如符合则保存在父列表ans中
			最后要删除子列表中最后一个元素用于回溯
		时间O(n)
		空间O(n)
	 */
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	List<List<Integer>> ans = new LinkedList<>();
	LinkedList<Integer> list = new LinkedList<>();
	public List<List<Integer>> pathSum(TreeNode root,int sum){
		res(root,sum);
		return ans;
	}

	public void res(TreeNode root,int N){
		if(root == null) return;
		list.add(root.val);
		N -= root.val;
		if(N==0 && root.left == null && root.right == null)
			ans.add(new LinkedList<>(list));
		res(root.left,N);
		res(root.right,N);
		list.removeLast();
	}
}

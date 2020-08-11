package com.company.leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author: XianDaLi
 * Date: 2020/8/11 23:44
 * Remark:
 */
public class O32_2 {

	private class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x){
			val = x;
		}
	}

	// 方式一：层次遍历
	/*List<List<Integer>> Olist = new ArrayList<>();
	public List<List<Integer>> levelOrder(TreeNode root) {
		res(root,0);
		return Olist;
	}
	public void res(TreeNode root,int k){
		if(root != null){
			if(Olist.size() <= k)
				Olist.add(new ArrayList<>());
			Olist.get(k).add(root.val);
			res(root.left,k+1);
			res(root.right,k+1);
		}
	}*/

	// 方式二： 使用队列BFS
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();
		if(root != null) queue.add(root);
		while (!queue.isEmpty()){
			List<Integer> list = new ArrayList<>();
			for (int i = queue.size(); i > 0; i--) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
			res.add(list);
		}
		return res;
	}

}

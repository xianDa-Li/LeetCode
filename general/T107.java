package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/6 14:23
 * Remark:
 */
public class T107 {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		if(root == null) return list;
		while (!queue.isEmpty()){
			List<Integer> temp = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();
				temp.add(tmp.val);
				if(tmp.left!=null) queue.add(tmp.left);
				if(tmp.right!=null) queue.add(tmp.right);
			}
				list.add(0,temp);
		}
		return list;
	}
}

package com.company.leetcode.offer;

import java.util.*;

public class O32 {
	private class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}

	public int[] levelOrder(TreeNode root) {
		if (root == null) return new int[0];
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		List<Integer> ans = new ArrayList<>();
		while (!q.isEmpty()){
			TreeNode head = q.poll();
			ans.add(head.val);
			if(head.left != null) q.add(head.left);
			if(head.right != null) q.add(head.right);
		}
		int[] res = new int[ans.size()];
		for(int i=0;i<ans.size();i++){
			res[i] = ans.get(i);
		}
		return res;
	}

}

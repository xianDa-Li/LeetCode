package com.company.leetcode.offer;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/8/12 1:03
 * Remark:
 */
public class O32_3 {

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x){
			val = x;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		if(root != null) q.add(root);
		while (!q.isEmpty()){
			LinkedList<Integer> list = new LinkedList<>();
			for (int i = q.size(); i > 0 ; i--) {
				TreeNode temp = q.poll();
				if(ans.size()%2 == 0) list.addLast(temp.val); // 偶数层
				else list.addFirst(temp.val); // 奇数层
				if(temp.left != null) q.add(temp.left);
				if(temp.right != null) q.add(temp.right);
			}
			ans.add(list);
		}
		return ans;
	}

}

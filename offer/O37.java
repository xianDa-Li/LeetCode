package com.company.leetcode.offer;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Author: XianDaLi
 * Date: 2020/8/24 18:58
 * Remark:
 */
public class O37 {

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if(root == null) return "[]";
		StringBuilder res = new StringBuilder("[");
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(node != null){
				res.append(node.val + ",");
				queue.add(node.left);
				queue.add(node.right);
			}else res.append("null,"); // 如果当前等于空直接添加null
		}
		res.deleteCharAt(res.length()-1); // 删掉最后一个,
		res.append("]");
		return res.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data.equals("[]")) return null;
		String[] vals = data.substring(1,data.length()-1).split(","); // 去掉 [ , ]
		TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int i = 1;
		while (!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(!vals[i].equals("null")){  // 不为空才添加
				node.left = new TreeNode(Integer.parseInt(vals[i]));
				queue.add(node.left);    // 首先添加左子节点
			}
			i++;
			if(!vals[i].equals("null")){
				node.right = new TreeNode(Integer.parseInt(vals[i]));
				queue.add(node.right);  // 再添加右子节点
			}
			i++;

		}
		return root;
	}
}

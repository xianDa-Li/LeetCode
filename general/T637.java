package com.company.leetcode.general;

import javax.swing.plaf.InsetsUIResource;
import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/12 23:24
 * Remark:给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 */
public class T637 {

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}

	public List<Double> averageOfLevels(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		List<Double> list = new ArrayList<>();
		q.add(root);
		while (!q.isEmpty()){
			double size = q.size();
			double sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode temp = q.poll();
				sum += temp.val;
				if(temp.left != null) q.add(temp.left);
				if(temp.right != null) q.add(temp.right);
			}
			list.add(sum/size);
		}
		return list;
	}
}

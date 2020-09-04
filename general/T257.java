package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/4 1:52
 * Remark:
 */
public class T257 {

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> ans = new ArrayList<>();
		bfs(ans,root,"");
		return ans;
	}

	public void bfs(List<String> ans,TreeNode root,String s){
		if(root != null){
			StringBuilder sb = new StringBuilder(s);
			sb.append(root.val);
			if(root.left == null && root.right == null){
				ans.add(sb.toString());
			}else {
				sb.append("->");
				bfs(ans,root.left,sb.toString());
				bfs(ans,root.right,sb.toString());
			}
		}
	}
}
